package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class loginBase{
    public static AppiumDriver<MobileElement> driver;

    @BeforeClass()
    public void startApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "AUM-L29");
        cap.setCapability("udid", "SSR9X18718G00381");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "8.0");
        cap.setCapability("appPackage", "com.faturaegypt.app.stage");
        cap.setCapability("appActivity", "com.faturaegypt.app.ui.MainActivity");
        //cap.setCapability("printPageSourceOnFindFailure", false);
        cap.setCapability("appWaitPackage", "20000");
        //cap.setCapability("forceEspressoRebuild", true);
        //cap.setCapability("androidScreenshotPath", "/target/screenshots");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<>(url, cap);
        System.out.println("the app has started successfully...");
    }
    @BeforeClass(dependsOnMethods = "startApp")
    public void login() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/logo")));
        driver.navigate().back();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/phone_number")));
        MobileElement numberField = driver.findElementById("com.faturaegypt.app.stage:id/textinput_placeholder");

        //using actions as the normal sendkeys isn't working
        Actions actions = new Actions(driver);
        actions.sendKeys(numberField, "01017319700").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/password")));
        MobileElement password = driver.findElementById("com.faturaegypt.app.stage:id/password");

        //clicking the element as action for some reason enters the below keys in number field.
        password.click();
        actions.sendKeys(password,"123321").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/btn_signin")));
        MobileElement loginBtn = driver.findElementById("com.faturaegypt.app.stage:id/btn_signin");
        loginBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/intorText")));
        Assert.assertTrue(driver.findElementById("com.faturaegypt.app.stage:id/intorText").getText().contains("هتعمل فاتورتك منين انهارده؟"));
        System.out.println("logged in successfully...");

    }

    @AfterClass
    public static void closeApp()throws InterruptedException {
        driver.closeApp();
    }

}
