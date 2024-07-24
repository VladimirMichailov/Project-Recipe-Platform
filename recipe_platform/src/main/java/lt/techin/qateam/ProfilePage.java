package lt.techin.qateam;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    // Delete account elements

    @FindBy(css = ".username.w-100")
    WebElement clickToGoProfilePage;

    @FindBy(css = ".delete-button")
    WebElement deleteAccountButton;

    @FindBy(css = ".modal-footer .btn-danger")
    WebElement submitDeleteButton;

    //Create recipe elements

    @FindBy(css = ".username.w-100")
    WebElement openMyAccount;

    @FindBy(css = ".buttons-content > button:nth-of-type(1)")
    WebElement createRecipeButton;


    @FindBy(css = "input#name")
    WebElement inputRecipeName;

    @FindBy(css = "input#image")
    WebElement inputImageUrl;

    @FindBy(css = "textarea#description")
    WebElement inputDescription;

    @FindBy(css = "textarea#instructions")
    WebElement inputInstruction;

    @FindBy(css = "#root > div:nth-child(3) > form > div:nth-child(6) > table > tbody > tr > td:nth-child(2) > button")
    WebElement addIngridientButton;

    @FindBy(css = "input[name='ingredients.0.title']")
    WebElement ingridientOneInput;

    @FindBy(css = "input[name='ingredients.1.title']")
    WebElement ingridientTwoInput;

    @FindBy(css = "input[name='ingredients.2.title']")
    WebElement ingridientThreeInput;

    @FindBy(css = "input[name='ingredients.3.title']")
    WebElement ingridientFourInput;

    @FindBy(css = "input[name='ingredients.4.title']")
    WebElement ingridientFiveInput;

    @FindBy(css = "input#timeInMinutes")
    WebElement timeInput;

    @FindBy(css = ".btn.submit-btn.w-100")
    WebElement addRecipeButton;

    @FindBy(css="div[role='alert'] > div:nth-of-type(2)")
    WebElement warningMessage;

    @FindBy(css="div:nth-of-type(3) > .recipe-list")
    WebElement listOfRecipes;

    @FindBy(css = ".logout")
    WebElement logoutButton;










    // Delete user methods

    public void clickToProfilePage() {
        clickToGoProfilePage.click();
    }

    public void clickToDeleteAccount(){
        deleteAccountButton.click();
    }

    public void submitDelete(){
        submitDeleteButton.click();
    }


    // Create recipe methods

    public void clickToOpenProfile(){openMyAccount.click();}


    public void clickToCreateRecipe(){createRecipeButton.click();}

    public void inputRecipeName(String recipeName) {
        inputRecipeName.sendKeys(recipeName);
    }

    public void inputRecipeImage(String imageUrl) {
        inputImageUrl.sendKeys(imageUrl);
    }

    public void inputRecipeDescription(String recipeDescription) {
        inputDescription.sendKeys(recipeDescription);
    }

    public void inputRecipeInsruction(String recipeInstruction) {
        inputInstruction.sendKeys(recipeInstruction);
    }

    public void clickToAddIngridient(){addIngridientButton.click();}

    public void inputIngridientOne(String ingridientOne) {
        ingridientOneInput.sendKeys(ingridientOne);
    }

    public void inputIngridientTwo(String ingridientTwo) {
        ingridientTwoInput.sendKeys(ingridientTwo);
    }

    public void inputIngridientThree(String ingridientThree) {
        ingridientThreeInput.sendKeys(ingridientThree);
    }

    public void inputIngridientFour(String ingridientFour) {
        ingridientFourInput.sendKeys(ingridientFour);
    }

    public void inputIngridientFive(String ingridientFive) {
        ingridientFiveInput.sendKeys(ingridientFive);
    }

    public void inputTime(String time) {
        timeInput.clear();
        timeInput.sendKeys(time);
    }

    public void clickToAddRecipe(){addRecipeButton.click();}

    public void clickToLogout(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }

    public void scrollDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void scrollToTimeInput() {
        Actions actions = new Actions(driver);
        actions.moveToElement(timeInput).perform();
    }

    public void scrollToListOfRecipes() {
        Actions actions = new Actions(driver);
        actions.moveToElement(listOfRecipes).perform();
    }

    public void scrollToButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(addRecipeButton).perform();
//        new Actions(driver)
//                .scrollToElement(addRecipeButton)
//                .perform();
    }

    public void moveMouseToAddRecipeButton(){
        Actions actions = new Actions(driver);
        actions.moveToElement(addRecipeButton).perform();

    }

    public void downByPixels(){
        new Actions(driver)
                .keyDown(Keys.DOWN)
                .perform();
    }


}
