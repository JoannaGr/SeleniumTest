package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SearchTest {
    private WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/");
    }

    @Test
    public void searchStore() {

        WebElement search = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
        search.clear();
        search.sendKeys("shoes");

        if (!driver.findElement(By.xpath("//input[@type='submit']")).isSelected()) {
            driver.findElement(By.xpath("//input[@type='submit']")).click();
        }

        WebElement positiveSearch = driver.findElement(By.id("q"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement aboutMeButton = wait.until(ExpectedConditions.elementToBeClickable(positiveSearch));

        assertEquals("shoes", positiveSearch.getAttribute("value"));
    }
    @After
    public void tearDown() {
        driver.close();
    }
}
