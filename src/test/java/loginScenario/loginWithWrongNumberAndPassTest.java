package loginScenario;

import Base.TestBase;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginWithWrongNumberAndPassTest extends TestBase {
    @Test
    public void login()
    {
        WebDriverWait wait =new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/logo")));
        driver.navigate().back();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/phone_number")));
        MobileElement numberField = driver.findElementById("com.faturaegypt.app.stage:id/textinput_placeholder");

        //using actions as the normal sendkeys isn't working
        Actions actions = new Actions(driver);
        actions.sendKeys(numberField, "111").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/password")));
        MobileElement password = driver.findElementById("com.faturaegypt.app.stage:id/password");

        //clicking the element as action for some reason enters the below keys in number field.
        password.click();
        actions.sendKeys(password,"111").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/btn_signin")));
        MobileElement loginBtn =  driver.findElementById("com.faturaegypt.app.stage:id/btn_signin");
        loginBtn.click();


        Assert.assertTrue(driver.findElementById("com.faturaegypt.app.stage:id/textinput_placeholder").isDisplayed());

    }
}
