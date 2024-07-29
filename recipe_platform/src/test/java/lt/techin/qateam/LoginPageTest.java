package lt.techin.qateam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageTest extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/random_user_credentials_email_password_only.csv", numLinesToSkip = 1)
    void loginToPage(String email, String password) throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registrationPage.clickToLoginLink();
        loginPage.inputEmailToLogin(email);
        loginPage.inputPasswordToLogin(password);
        loginPage.clickToLogin();
        loginPage.waitForNewPage();
        Assertions.assertEquals("http://localhost:5173/recipes", driver.getCurrentUrl(), "web addresses not match");
        Assertions.assertEquals("Login successfull!", loginPage.getSuccessLoginMessage(), "messages not match");

    }

    @Test
    void loginToPageStaticData() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        registrationPage.clickToLoginLink();
        loginPage.inputEmailToLogin("testas21@gmail.com");
        loginPage.inputPasswordToLogin("Testas+5");
        loginPage.clickToLogin();
        loginPage.waitForNewPage();
        Assertions.assertEquals("http://localhost:5173/recipes", driver.getCurrentUrl(), "web addresses not match");
        Assertions.assertEquals("Login successfull!", loginPage.getSuccessLoginMessage(), "messages not match");
    }
}
