import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class NewTest {
    public AppiumDriver<WebElement> driver;
    public WebDriverWait wait;
    public TouchAction touchAction;
private WebElement webElement;
    @BeforeMethod
    public void setupDevice() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "General Mobile 4G");
        desiredCapabilities.setCapability("udid", "79dfda34");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "7.1.1");
        desiredCapabilities.setCapability("appPackage", "com.example.work.thetestingworld");
        desiredCapabilities.setCapability("automationName", "uiautomotor2");
        desiredCapabilities.setCapability("appActivity", "com.example.work.thetestingworld.Splash");
        desiredCapabilities.setCapability("appWaitActivity", "com.example.work.thetestingworld.DetailsActivity");
        desiredCapabilities.setCapability("skipUnlock", "true");
        desiredCapabilities.setCapability("noReset", "false");
        driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        wait = new WebDriverWait(driver, 20);
        touchAction = new TouchAction(driver);
    }

    @Test
    public void testWorldExample() throws InterruptedException {
        init();
        sleepALitle();
    }

    private void init() {
        driver.findElementById("register").click();
        driver.findElementById("name").sendKeys("Ayse");
        driver.findElementById("last_name").sendKeys("Arman");
        driver.findElement(By.xpath(ViewPaths.CB_CALİSAN)).click();
        driver.findElementById("dob").click();
        driver.findElementById("android:id/prev").click();
        driver.findElement(By.xpath("//android.view.View[@content-desc=\"18 Eylül 2018\"]")).click();
        driver.findElementById("android:id/button1").click();
        pressBack();
        scrollScreen();
        driver.findElementById("toggleOnOff").click();
        driver.findElementById("country").click();
        driver.findElementById("country_list").click();
        driver.findElement(By.xpath(ViewPaths.LIST_PATH)).click();
        driver.findElementById("email").sendKeys("a.a@a.com");
        driver.findElementById("mobile").sendKeys("5555869596");
        pressBack();
        driver.findElement(By.xpath(ViewPaths.CB2)).click();
        driver.findElement(By.xpath(ViewPaths.CB3)).click();
        driver.findElement(By.xpath(ViewPaths.RB_PATH)).click();
        driver.findElementById("submit").click();
        webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ViewPaths.THANKS_PATH)));
        boolean isDisp=webElement.isDisplayed();
         if (isDisp){
            System.out.println("Test okey");
        }
    }

        private void sleepALitle () {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void scrollScreen () {
            touchAction.press(120, 1000).waitAction(400).moveTo(120, 600).release();
            touchAction.perform();
        }

        private void pressBack () {
            driver.navigate().back();
        }

        @AfterMethod
        public void teardown () {
            driver.quit();
        }
    }
