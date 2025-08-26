package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScanProducts {

    WebDriver driver;

    // Constructor to connect WebDriver
    public ScanProducts(WebDriver driver) {
        this.driver = driver;
    }

    public void scanProducts(List<String> productCodes) throws InterruptedException {
        for (String code : productCodes) {
            WebElement productInput = driver.findElement(By.xpath("//input[@id=\"productsearch\"]")); // Update this
            productInput.clear();
            productInput.sendKeys(code);
            productInput.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
        }
    }
}




