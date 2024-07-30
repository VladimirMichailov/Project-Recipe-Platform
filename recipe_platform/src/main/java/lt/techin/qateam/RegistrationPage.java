package lt.techin.qateam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver) {super(driver);}

    @FindBy(css = "input#userName")
            WebElement usernameInput;
    @FindBy(css = "input#email")
    WebElement emailInput;
    @FindBy(css = "input#password")
    WebElement passwordInput;
    @FindBy(css = "#repeatPassword")
    WebElement repeatPasswordInput;
    @FindBy(css = "[class='btn submit-btn w-100']")
    WebElement registerButton;
    @FindBy(css = ".nav-login")
    WebElement linkToLogin;
    @FindBy(css = ".Toastify")
    WebElement registrationWarningMessage;

    public void inputUsername(String username){
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }
    public void inputEmail(String email){
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void inputPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void inputRepeatPassword(String repeatPassword){
        repeatPasswordInput.clear();
        repeatPasswordInput.sendKeys(repeatPassword);
    }
    public void clickToRegister(){registerButton.click();}

    public void clickToLoginLink(){linkToLogin.click();}

    public void waitForNewPage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/login"));
    }

    public String getSuccessRegistrationMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByCssSelector(".Toastify")));
        return registrationWarningMessage.getText();
    }






}