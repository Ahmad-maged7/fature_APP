package loginScenario;

import Base.TestBase;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginWithBlankFieldsTest extends TestBase {

    @Test
    public void login()
    {
        WebDriverWait wait =new WebDriverWait(TestBase.driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/logo")));
        TestBase.driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/btn_signin")));
        MobileElement loginBtn =  TestBase.driver.findElementById("com.faturaegypt.app.stage:id/btn_signin");
        loginBtn.click();


        Assert.assertTrue(TestBase.driver.findElementById("com.faturaegypt.app.stage:id/textinput_placeholder").isDisplayed());

    }
}
