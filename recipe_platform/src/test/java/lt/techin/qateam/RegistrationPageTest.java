package lt.techin.qateam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPageTest extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/random_user_credentials.csv", numLinesToSkip = 1)
    void registerToPage(String username, String email, String password, String repeatPassword) throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.inputUsername(username);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(repeatPassword);
        registrationPage.clickToRegister();
        registrationPage.waitForNewPage();
        Assertions.assertEquals("http://localhost:5173/login", driver.getCurrentUrl(), "web addresses not match");
        Assertions.assertEquals("User created successfully!", registrationPage.getSuccessRegistrationMessage());
    }

    @Test
    void registerToPage() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.inputUsername("Testas7777");
        registrationPage.inputEmail("testas7777@gmail.com");
        registrationPage.inputPassword("Testas+5");
        registrationPage.inputRepeatPassword("Testas+5");
        registrationPage.clickToRegister();
        registrationPage.waitForNewPage();
        Assertions.assertEquals("http://localhost:5173/login", driver.getCurrentUrl(), "web addresses not match");
        Assertions.assertEquals("User created successfully!", registrationPage.getSuccessRegistrationMessage());
    }
}
