package helper;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHelper {
	
	WebDriver driver;

    public WindowHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void closeAllOtherWindowsExceptMain() {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                driver.close();
            }
        }

        driver.switchTo().window(mainWindow);
    }
}


