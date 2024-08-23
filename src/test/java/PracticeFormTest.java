import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeFormTest {
    private WebDriver driver;
    private PracticeForm practiceForm;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        practiceForm = new PracticeForm(driver);
        String heading = practiceForm.getHeading();
        Assert.assertEquals("Practice Form", heading);
    }

    @Test
    public void testSubmiting() {
        practiceForm.submiting("Sam","White","name@example.com","7999888777","D:\\test\\testImage.png","1600 Fake Street Apartment 1");
        Assert.assertTrue(practiceForm.getSubmitingMessage());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
