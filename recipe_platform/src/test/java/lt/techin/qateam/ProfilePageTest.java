package lt.techin.qateam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePageTest extends BaseTest{

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/random_user_credentials_email_password_only.csv", numLinesToSkip = 1)
    void deleteUser(String email, String password) throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        registrationPage.clickToLoginLink();
        loginPage.inputEmailToLogin(email);
        loginPage.inputPasswordToLogin(password);
        loginPage.clickToLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/recipes"));
        profilePage.clickToProfilePage();
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/profile"));
        profilePage.clickToDeleteAccount();
        profilePage.submitDelete();



    }

    @Test
    void createRecipe() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        registrationPage.clickToLoginLink();
        loginPage.inputEmailToLogin("testas221@gmail.com");
        loginPage.inputPasswordToLogin("Testas+5");
        loginPage.clickToLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/recipes"));
        profilePage.clickToOpenProfile();
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/profile"));
        profilePage.clickToCreateRecipe();
        profilePage.inputRecipeName("Chicken Stir-Fry");
        profilePage.inputRecipeImage("https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F43%2F2022%2F04%2F29%2F223382_chicken-stir-fry_Rita-1x1-1.jpg&q=60&c=sc&poi=auto&orient=true&h=512");
        profilePage.inputRecipeDescription("This chicken stir-fry recipe is packed with veggies and is quick and easy to prepare. Try adding bean sprouts, bamboo shoots, snap peas, or any of your favorite vegetables. Serve it with white or brown rice, or noodles.");
        profilePage.inputRecipeInsruction("How to Make Chicken Stir Fry\n" +
                "You'll find the full, step-by-step recipe below — but here's a brief overview of what you can expect when you make chicken stir fry at home:\n" +
                "\n" +
                "1. Stir the soy sauce, sugar, cornstarch, and spices together.\n" +
                "2. Add the chicken and toss. Cover and marinate.\n" +
                "3. Cook the vegetables and water chestnuts in sesame oil.\n" +
                "4. Cook the marinated chicken, then stir in the veggies and reserved marinade.\n" +
                "5. Boil until the chicken is fully cooked. Serve over rice.");

        profilePage.scrollToTimeInput();
        profilePage.inputIngridientOne("4 cups water");
        profilePage.clickToAddIngridient();
        profilePage.inputIngridientTwo("1 tablespoon cornstarch");
        profilePage.clickToAddIngridient();
        profilePage.inputIngridientThree("3 skinless, boneless chicken breast halves, thinly sliced");
        profilePage.clickToAddIngridient();
        profilePage.inputIngridientFour("1 onion, cut into large chunks");
        profilePage.clickToAddIngridient();
        profilePage.inputIngridientFive("1 green bell pepper, cut into matchsticks");
        profilePage.inputTime("25");
        profilePage.scrollToListOfRecipes();
        profilePage.clickToAddRecipe();
        //Thread.sleep(5000);
       // profilePage.clickToLogout();


    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/recipes2.csv", numLinesToSkip = 1)
    void createRecipeFromCvs(String recipeName,String imageUrl, String recipeDescription,String recipeInstruction, String ingridientOne, String ingridientTwo, String ingridientThree, String ingridientFour, String ingridientFive, String time ) throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        registrationPage.clickToLoginLink();
        loginPage.inputEmailToLogin("testas221@gmail.com");
        loginPage.inputPasswordToLogin("Testas+5");
        loginPage.clickToLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/recipes"));
        profilePage.clickToOpenProfile();
        wait.until(ExpectedConditions.urlToBe("http://localhost:5173/profile"));
        profilePage.clickToCreateRecipe();
        profilePage.inputRecipeName(recipeName);
        profilePage.inputRecipeImage(imageUrl);
        profilePage.inputRecipeDescription(recipeDescription);
        profilePage.inputRecipeInsruction(recipeInstruction);
        profilePage.scrollToTimeInput();
        profilePage.inputIngridientOne(ingridientOne);
        profilePage.clickToAddIngridient();
        profilePage.inputIngridientTwo(ingridientTwo);
        profilePage.clickToAddIngridient();
        profilePage.inputIngridientThree(ingridientThree);
        profilePage.clickToAddIngridient();
        profilePage.inputIngridientFour(ingridientFour);
        profilePage.clickToAddIngridient();
        profilePage.inputIngridientFive(ingridientFive);
        profilePage.inputTime(time);
        profilePage.scrollToListOfRecipes();
        profilePage.clickToAddRecipe();
        //profilePage.clickToLogout();


    }
}
