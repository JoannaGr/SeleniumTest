package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/login");
    }

    @Test
    public void ReturningCustomerLogin() {

        WebElement eMail = driver.findElement(By.xpath("//input[@id='Email']"));
        eMail.clear();
        eMail.sendKeys("adas.iksiński@wp.pl");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.clear();
        password.sendKeys("123abc456def$");

        if (!driver.findElement(By.xpath("//input[@class='button-1 login-button']")).isSelected()) {
            driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
        }

        WebElement positiveLogin = driver.findElement(By.className("topic-block-title"));
        assertEquals("Welcome to our store", positiveLogin.getText());
    }
    @After
    public void tearDown() {
        driver.close();
    }


}
