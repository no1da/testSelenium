import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    static WebDriver driver;
    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        PracticeForm practiceForm = new PracticeForm(driver);

        practiceForm.submiting("Sam","White","name@example.com","7999888777","D:\\test\\testImage.png","1600 Fake Street Apartment 1");

    }
}
