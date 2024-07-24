package lt.techin.qateam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPageTest extends BaseTest{
    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/random_user_credentials.csv", numLinesToSkip = 1)
    void registerToPage(String username, String email, String password, String repeatPassword) throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.inputUsername(username);
        registrationPage.inputEmail(email);
        registrationPage.inputPassword(password);
        registrationPage.inputRepeatPassword(repeatPassword);
        registrationPage.clickToRegister();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/login"));
        Assertions.assertEquals("http://localhost:5173/login",driver.getCurrentUrl(),"web addresses not match");
    }
@Test
    void registerToPage() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.inputUsername("Testas211");
        registrationPage.inputEmail("testas210@gmail.com");
        registrationPage.inputPassword("Testas+5");
        registrationPage.inputRepeatPassword("Testas+5");
        registrationPage.clickToRegister();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/login"));
        Assertions.assertEquals("http://localhost:5173/login",driver.getCurrentUrl(),"web addresses not match");
    }
}
