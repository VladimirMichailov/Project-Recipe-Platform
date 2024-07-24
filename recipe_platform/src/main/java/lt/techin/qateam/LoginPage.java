package lt.techin.qateam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {super(driver);}

    @FindBy(css = "input#email")
    WebElement emailInputToLogin;
    @FindBy(css = "input#password")
    WebElement passwordInputToLogin;
    @FindBy(css = ".btn.login-btn.w-100")
    WebElement loginButton;
    @FindBy(css = "div[role='alert'] > div:nth-of-type(2)")
    WebElement loginWarningMessage;

    public void inputEmailToLogin(String email) {
        emailInputToLogin.sendKeys(email);
    }
    public void inputPasswordToLogin(String password){
        passwordInputToLogin.sendKeys(password);
    }
    public void clickToLogin(){loginButton.click();}


}
