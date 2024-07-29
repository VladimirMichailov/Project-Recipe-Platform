package lt.techin.qateam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {super(driver);}

    @FindBy(css = "input#email")
    WebElement emailInputToLogin;
    @FindBy(css = "input#password")
    WebElement passwordInputToLogin;
    @FindBy(css = ".btn.login-btn.w-100")
    WebElement loginButton;
    @FindBy(css = ".Toastify")
    WebElement warningMessage;

    public void inputEmailToLogin(String email) {
        emailInputToLogin.sendKeys(email);
    }
    public void inputPasswordToLogin(String password){
        passwordInputToLogin.sendKeys(password);
    }
    public void clickToLogin(){loginButton.click();}

    public void waitForNewPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/recipes"));
    }

    public String getSuccessLoginMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector(".Toastify")));
       return warningMessage.getText();
    }


}
