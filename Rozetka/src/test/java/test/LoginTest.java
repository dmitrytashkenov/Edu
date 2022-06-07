package test;

import com.github.automatedowl.tools.JSErrorsCollectorTestNG;
import controller.MainPageController;
import dataProvider.GetPropertyValue;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;
import java.util.Date;


public class LoginTest {
    GetPropertyValue getPropertyValue;
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        getPropertyValue = new GetPropertyValue();
        System.setProperty("webdriver.chrome.driver", getPropertyValue.getChromedriver());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=\\Users\\user2\\Library\\Application Support\\Google\\Chrome");
        options.addArguments("--profile-directory=Profile 5");
        final Cookie COOKIE = new Cookie("SID", "Igh6JGPWPfslhHM0RbQs1iEEJlw8xPuReoEw2_BtTq-KjJRB3ENuTigBnOBlC7LuI6e_yg.");
        driver = new ChromeDriver(options);
        driver.manage().addCookie(COOKIE);
        driver.manage().window().maximize();
        driver.get(getPropertyValue.getApplicationUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    @JSErrorsCollectorTestNG
    public void loginErrorInvalidEmail() throws InterruptedException {
        MainPageController mainPageController = new MainPageController(driver);

        mainPageController.openLoginModal();
        mainPageController.element.loginField.sendKeys("test@ail.com");
        mainPageController.element.passwordField.sendKeys(getPropertyValue.getPassword());
        mainPageController.setRememberUsername(true);
        mainPageController.element.submitButton.click();
        mainPageController.waitCaptcha();
        mainPageController.element.captchaCheckbox.click();
        mainPageController.element.submitButton.click();
        Assert.assertEquals(mainPageController.element.invalidEmailActual, mainPageController.element.invalidEmailExpected);
    }

    @Test(priority = 2)
    @JSErrorsCollectorTestNG
    public void loginErrorInvalidPassword() throws InterruptedException {
        MainPageController mainPageController = new MainPageController(driver);

        mainPageController.openLoginModal();
        mainPageController.element.loginField.sendKeys(getPropertyValue.getEmail());
        mainPageController.element.passwordField.sendKeys("test");
        mainPageController.setRememberUsername(true);
        mainPageController.element.submitButton.click();
        mainPageController.waitCaptcha();
        mainPageController.element.captchaCheckbox.click();
        mainPageController.element.submitButton.click();
        Assert.assertEquals(mainPageController.element.invalidPasswordActual, mainPageController.element.invalidPasswordExpected);
    }
}
