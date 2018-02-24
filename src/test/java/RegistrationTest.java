import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;


public class RegistrationTest {

    private WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/register");
    }

    @Test
    public void fillRegistrationForm() {

        if (!driver.findElement(By.xpath("//input[@id='gender-male']")).isSelected()) {
            driver.findElement(By.xpath("//input[@id='gender-male']")).click();


            WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
            firstName.clear();
            firstName.sendKeys("Adam");

            WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
            lastName.clear();
            lastName.sendKeys("Iksiński");

            Select selectDay = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
            selectDay.selectByVisibleText("5");
            Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
            selectMonth.selectByVisibleText("September");
            Select selectYear = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
            selectYear.selectByVisibleText("1987");


            WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
            email.clear();
            email.sendKeys("adas.iksiński@wp.pl");

            WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
            password.clear();
            password.sendKeys("123abc456def$");

            WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
            confirmPassword.clear();
            confirmPassword.sendKeys("123abc456def$");

            if (!driver.findElement(By.xpath("//input[@id='register-button']")).isSelected()) {
                driver.findElement(By.xpath("//input[@id='register-button']")).click();
            }

            WebElement positiveRegistration = driver.findElement(By.className("result"));
            assertEquals("Your registration completed", positiveRegistration.getText());            }

        }

    @After
    public void tearDown() {
        driver.close();
    }
}

