package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public static AppiumDriver<MobileElement> driver;

    @BeforeClass
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


    @AfterClass
    public static void closeApp() {
        driver.closeApp();
    }


}
