package object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {

    public String invalidEmailExpected = "Пользователь с логином test@ail.com не зарегистрирован";
    public String invalidPasswordExpected = "Введен неверный пароль!";

    @FindBy(how = How.CSS, using = "rz-user.header-actions__component > button.header__button.ng-star-inserted")
    @CacheLookup
    public WebElement loginButton;

    @FindBy(how = How.CSS, using = "#auth_email")
    @CacheLookup
    public WebElement loginField;

    @FindBy(how = How.CSS, using = "#auth_pass")
    @CacheLookup
    public WebElement passwordField;

    @FindBy(how = How.CSS, using = "button.button.button--large.button--green.auth-modal__submit.ng-star-inserted")
    @CacheLookup
    public WebElement submitButton;

    @FindBy(how = How.CSS, using = "label.auth-modal__remember-checkbox")
    @CacheLookup
    public WebElement rememberMeCheckbox;

    @FindBy(how = How.XPATH, using = "//re-captcha[@id='ngrecaptcha-0']")
    @CacheLookup
    public WebElement captchaCheckbox;

    @FindBy(how = How.CSS, using = "p.error-message.ng-star-inserted")
    @CacheLookup
    public WebElement invalidEmailActual;

    @FindBy(how = How.XPATH, using = "//strong[contains(text(),'Введен неверный пароль!')]")
    @CacheLookup
    public WebElement invalidPasswordActual;

}
