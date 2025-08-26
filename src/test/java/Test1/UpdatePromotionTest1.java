package Test1;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions; // For Firefox specific options
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration; // For WebDriverWait timeout
import java.util.ArrayList;
import java.util.List;
// For logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdatePromotionTest1 {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    // --- Configuration ---
    private static final String WEB_URL = "https://test-unify.etpgroup.sg";
    private static final String USERNAME = "egs.enterprise@etpgroup.com";
    private static final String PASSWORD = "Egs@1612";
    private static final int WAIT_TIMEOUT_SECONDS = 20; // Seconds for explicit waits

    // --- Product Name Generation Configuration ---
    private static final String PRODUCT_PREFIX = "Sylphy";
    private static final int START_PRODUCT_NUMBER = 1;
    private static final int END_PRODUCT_NUMBER = 5; // Start with a very small number for testing!
                                                    // Gradually increase to 1000000

    // Logger setup
    private static final Logger logger = LoggerFactory.getLogger(UpdatePromotionTest1.class);

    @Before
    public void setUp() {
        // Set up Firefox options
        FirefoxOptions options = new FirefoxOptions();
        // Uncomment the line below to run in headless mode (no browser UI)
        options.addArguments("--headless"); // Highly recommended for 1M records
        
        // Path to geckodriver executable (uncomment and set if not in PATH)
        // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver.exe"); 
        
        driver = new FirefoxDriver(options);
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        
        driver.manage().window().setSize(new Dimension(1295, 687)); // Set initial window size
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void login() {
        logger.info("Attempting to log in...");
        driver.get(WEB_URL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtLoginId"))).click();
        driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
        driver.findElement(By.id("txtLoginId")).sendKeys(USERNAME);
        
        driver.findElement(By.id("btnLogin")).click();

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-input")));
            logger.info("Login successful.");
        } catch (Exception e) {
            logger.error("Login failed: " + e.getMessage());
            throw new RuntimeException("Login failed", e); // Re-throw to fail the test
        }
    }

    private void navigateToPromotions() {
        logger.info("Navigating to Promotions...");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-input"))).click();
        driver.findElement(By.id("pricingpromotion_anchor")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Promotions"))).click();
        logger.info("Reached Promotions page.");
    }

    private void openPromotionForEditing() {
        logger.info("Opening promotion for editing (first one in list)...");
        try {
            // Wait for the table row to be present before clicking the icon
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".td-hove:nth-child(1) .mat-icon"))).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cdk-focused"))).click();
            logger.info("Promotion opened.");
        } catch (Exception e) {
            logger.error("Failed to open promotion for editing. Element not found or not clickable: " + e.getMessage());
            // Optionally, take a screenshot here if running in non-headless mode for debugging
            // You'll need to add a method for taking screenshots.
            throw new RuntimeException("Failed to open promotion", e); // Re-throw to fail the test
        }
    }

    private boolean addProductToPromotion(String productName) {
        logger.info("Attempting to add product: " + productName);
        try {
            // Click the button to add products (assuming it opens a modal or section)
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".activeBtn"))).click();
            
            // These clicks might be needed to open the search modal. Use a shorter wait.
            try {
                wait.withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("v-265"))).click();
                wait.withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".textChange"))).click();
            } catch (Exception e) {
                logger.warn("Optional clicks (v-265 or textChange) did not appear or were skipped (might be normal): " + e.getMessage());
                // Continue execution even if these aren't found, as they might be context-dependent
            }

            // Wait for and interact with the search input for catalog
            wait.until(ExpectedConditions.elementToBeClickable(By.id("searchCatalog"))).click();
            driver.findElement(By.id("searchCatalog")).sendKeys(productName);
            
            // Wait for search results to load and click the add button
            // !!! VERY IMPORTANT: THIS ASSUMES THE PRODUCT APPEARS AND IS THE FIRST RESULT.
            // Adjust locator if the search results are not always the first element with .addColor
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".addColor"))).click();

            // Click to confirm adding the product 
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".hb-ripple:nth-child(1)"))).click();

            // Handle page loader/saving
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("pageloader")));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loaderPosition")));
            } catch (Exception e) {
                logger.info("No pageloader or loaderPosition element found or it disappeared quickly, or wait timed out (might be normal): " + e.getMessage());
                // Continue execution
            }

            logger.info("Successfully added product: " + productName);
            return true;
        } catch (Exception e) {
            logger.error("Failed to add product " + productName + ": " + e.getMessage());
            // Consider taking a screenshot on failure
            // TakeScreenshot.saveScreenshot(driver, "failure_" + productName.replaceAll("[^a-zA-Z0-9.-]", "_") + ".png");
            return false;
        }
    }

    @Test
    public void testAddProductsToPromotionDynamically() {
        login();
        navigateToPromotions();
        openPromotionForEditing();

        int successfulAdditions = 0;
        int failedAdditions = 0;
        List<String> productNamesToAdd = new ArrayList<>();

        // Generate product names dynamically
        for (int i = START_PRODUCT_NUMBER; i <= END_PRODUCT_NUMBER; i++) {
            productNamesToAdd.add(PRODUCT_PREFIX + i);
        }
        int totalProducts = productNamesToAdd.size();
        logger.info("Dynamically generated " + totalProducts + " product names from " + 
                    PRODUCT_PREFIX + START_PRODUCT_NUMBER + " to " + PRODUCT_PREFIX + END_PRODUCT_NUMBER + ".");

        try {
            for (int i = 0; i < totalProducts; i++) {
                String productName = productNamesToAdd.get(i);
                logger.info("Processing product " + (i + 1) + "/" + totalProducts + ": " + productName);
                if (addProductToPromotion(productName)) {
                    successfulAdditions++;
                } else {
                    failedAdditions++;
                }
                
                // Add a small delay between product additions to be less aggressive on the server
                // This is CRITICAL for 1M records. Adjust based on server load.
                try {
                    Thread.sleep(100); // 100 milliseconds delay
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // Restore interrupt status
                } 

                // IMPORTANT: For 1 million records, you might hit session timeouts or page stability issues.
                // Consider re-navigating or refreshing every X products if you encounter issues.
                // For initial small tests, this is not critical, but keep it in mind for scaling up.
                // if ((i + 1) % 500 == 0) { // Example: Re-open every 500 products
                //     logger.info("Re-navigating to promotion editing page after " + (i + 1) + " products...");
                //     // Option 1: Refresh (might lose state if not careful)
                //     // driver.navigate().refresh();
                //     // Option 2: Full re-navigation (safer but slower, and might create new promotion if not handled)
                //     // navigateToPromotions();
                //     // openPromotionForEditing(); // This would re-select the first promotion for editing.
                // }
            }
        } catch (Exception e) {
            logger.error("An unhandled error occurred during dynamic product addition: " + e.getMessage(), e);
        } finally {
            logger.info("--- Automation Summary ---");
            logger.info("Total Products Attempted: " + totalProducts);
            logger.info("Successful Additions: " + successfulAdditions);
            logger.info("Failed Additions: " + failedAdditions);
            
            // If the promotion page requires a final "Save" button click after adding all products,
            // you MUST add that here.
            // Example:
            // try {
            //    logger.info("Attempting to click final save button for the promotion...");
            //    wait.until(ExpectedConditions.elementToBeClickable(By.id("finalSaveButtonId"))).click();
            //    logger.info("Final save button clicked successfully.");
            // } catch (Exception e) {
            //    logger.error("Failed to click final save button: " + e.getMessage());
            // }
        }
    }
}