package SubmitOrderScenario;

import Base.loginBase;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class submitAnOrderTest extends loginBase {

    @Test(priority = 1)
    public void goToNotebook() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        MobileElement compoundNotebook = driver.findElementById("com.faturaegypt.app.stage:id/wholesalers");
        wait.until(ExpectedConditions.visibilityOf(compoundNotebook));
        compoundNotebook.click();}

    @Test(priority = 2,dependsOnMethods = "goToNotebook")
    public void addItemToCart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/product_image")));
        MobileElement addBtn = driver.findElementById("com.faturaegypt.app.stage:id/addCash");
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        addBtn.click();
        Thread.sleep(1000);
    }
    @Test(priority = 3,dependsOnMethods = "addItemToCart")
    public void goToCartAndCompleteOrder() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        MobileElement cart = driver.findElementById("com.faturaegypt.app.stage:id/min_layout");
        cart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/btn_order_now")));
        MobileElement orderNowBtn = driver.findElementById("com.faturaegypt.app.stage:id/btn_order_now");
        orderNowBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/confirmButton")));
        MobileElement confirmOrder = driver.findElementById("com.faturaegypt.app.stage:id/confirmButton");
        confirmOrder.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
        MobileElement confirmMsg = driver.findElementById("android:id/message");
        Assert.assertTrue(confirmMsg.getText().contains("تم ارسال طلبكم بنجاح"));

        MobileElement okBtn = driver.findElementById("android:id/button1");
        okBtn.click();
    }
    @Test(priority = 4,dependsOnMethods = "goToCartAndCompleteOrder")
    public void logOut() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        MobileElement myAccount = driver.findElementById("com.faturaegypt.app.stage:id/nav_profile");
        myAccount.click();

        TouchAction actions = new TouchAction(driver);
        Thread.sleep(1000);
        actions.press(PointOption.point(50,1200)).moveTo(PointOption.point(50,100)).release().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/btn_logout")));
        MobileElement logout =driver.findElementById(("com.faturaegypt.app.stage:id/btn_logout"));
        logout.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
        driver.findElementById("android:id/button1").click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.faturaegypt.app.stage:id/toolbar_title")));
        Assert.assertTrue(driver.findElementById("com.faturaegypt.app.stage:id/toolbar_title").getText().contains("أهلا بكم في برنامج فاتورة"));

    }
}
