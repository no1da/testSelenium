import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PracticeForm {
    private WebDriver driver;
    private By firstName = By.xpath("//input[@id=\"firstName\"]");
    private By lastName = By.xpath("//input[@id=\"lastName\"]");
    private By userEmail = By.xpath("//input[@id=\"userEmail\"]");
    private By genterWrapper = By.xpath("//div[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private By userNumber = By.xpath("//input[@id=\"userNumber\"]");
    private By dateOfBirthInput = By.xpath("//input[@id=\"dateOfBirthInput\"]");
    private By monthSelect = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select");
    private By monthOption = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/select/option[6]");
    private By yearSelect = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select");
    private By yearOption = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select/option[95]");
    private By dayBirthDate = By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[5]");
    private By subjectsInput = By.xpath("//*[@id=\"subjectsInput\"]");
    private By subjectsInputClick = By.xpath("//*[@id=\"subjectsInput\"]");
    private By subjectsContainer = By.xpath("//*[@id=\"subjectsContainer\"]/div[2]");
    private By hobbiesWrapper = By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div[1]/label");
    private By uploadPicture = By.xpath("//input[@id=\"uploadPicture\"]");
    private By currentAddress = By.id("currentAddress");
    private By scrollElement = By.xpath("//*[@id=\"state\"]");
    private By state = By.xpath("//*[@id=\"state\"]");
    private By stateClick = By.xpath("//*[@id=\"state\"]/div[2]");
    private By city = By.xpath("//*[@id=\"city\"]");
    private By cityClick = By.xpath("//*[@id=\"city\"]/div[2]");
    private By submit = By.cssSelector("#submit");
    private String subject = "Computer";
    private By heading = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/h1");
    private By submitingMessage = By.xpath("//*[@id=\"example-modal-sizes-title-lg\"]");

    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }

    public PracticeForm typeFirstName(String name) {
        driver.findElement(firstName).sendKeys(name);
        return this;
    }

    public PracticeForm typeLastName(String surname) {
        driver.findElement(lastName).sendKeys(surname);
        return this;
    }

    public PracticeForm typeUserEmail(String email) {
        driver.findElement(userEmail).sendKeys(email);
        return this;
    }

    public PracticeForm selectGender() {
        driver.findElement(genterWrapper).click();
        return this;
    }

    public PracticeForm typeUserNumber(String number) {
        driver.findElement(userNumber).sendKeys(number);
        return this;
    }

    public PracticeForm selectDateOfBirth() {
        driver.findElement(dateOfBirthInput).click();
        driver.findElement(monthSelect).click();
        driver.findElement(monthOption).click();
        driver.findElement(yearSelect).click();
        driver.findElement(yearOption).click();
        driver.findElement(dayBirthDate).click();
        return this;
    }

    public PracticeForm selectSubject() {
        driver.findElement(subjectsInput).sendKeys(subject);
        driver.findElement(subjectsInputClick).click();
        driver.findElement(subjectsContainer).click();
        return this;
    }

    public PracticeForm selectHobbies() {
        driver.findElement(hobbiesWrapper).click();
        return this;
    }

    public PracticeForm uploadPicture(String path) {
        driver.findElement(uploadPicture).sendKeys(path);
        return this;
    }

    public PracticeForm typeCurrentAddress(String adress) {
        driver.findElement(currentAddress).sendKeys(adress);
        return this;
    }

    public PracticeForm location() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(scrollElement));
        driver.findElement(state).click();
        driver.findElement(stateClick).click();
        driver.findElement(city).click();
        driver.findElement(cityClick).click();
        return this;
    }

    public PracticeForm clickSubmit() {
        driver.findElement(submit).click();
        return this;
    }

    public PracticeForm submiting(String name, String surname, String email, String number,String path,String adress) {
        this.typeFirstName(name);
        this.typeLastName(surname);
        this.typeUserEmail(email);
        this.selectGender();
        this.typeUserNumber(number);
        this.selectDateOfBirth();
        this.selectSubject();
        this.selectHobbies();
        this.uploadPicture(path);
        this.typeCurrentAddress(adress);
        this.location();
        this.clickSubmit();
        return new PracticeForm(driver);
    }

    public boolean getSubmitingMessage() {
        List<WebElement> elements = driver.findElements(submitingMessage);
        return !elements.isEmpty();
    }

    public String getHeading() {
        return driver.findElement(heading).getText();
    }
}
