package controller;

import object.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageController {

    private WebDriver webDriver;
    public MainPage element;

    public MainPageController (WebDriver webDriver) {
        this.webDriver = webDriver;
        this.element = new MainPage();
        PageFactory.initElements(webDriver, element);
    }

    public MainPageController openLoginModal () {
        element.loginButton.click();
        return this;
    }

    public boolean isRememberUsernameChecked() {
        return element.rememberMeCheckbox.isSelected();
    }

    public void setRememberUsername(boolean checkIt) {
        boolean alreadySelected = isRememberUsernameChecked();

        //прожимается, только если цель теста не соответствует текущему состоянию
        if( (checkIt && !alreadySelected) || (!checkIt && alreadySelected) ) {
            element.rememberMeCheckbox.click();
        }
    }

    public MainPageController waitCaptcha() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.rc-anchor-aria-status")));
        return this;
    }

}
