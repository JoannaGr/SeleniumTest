import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


@RunWith(DataProviderRunner.class)
public class DDTWithTngTechTest {

    private static final String PAGE_URL = "http://bmi-online.pl/";

    private WebDriver driver;

    @DataProvider
    public static Object[][] BMITest() {
        return new String[][]{
                new String[]{"40", "170"},
                new String[]{"47", "170"},
                new String[]{"50", "170"},
                new String[]{"60", "170"},
                new String[]{"90", "180"},
                new String[]{"110", "180"},
                new String[]{"125", "180"},
                new String[]{"140", "180"},

        };
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://bmi-online.pl/");

    }

    @Test
    @UseDataProvider("BMITest")
    public void dataToIndexBMI(String balance, String growth) {
        WebElement balanceKg = driver.findElement(By.xpath("//input[@type='number']"));
        balanceKg.sendKeys(balance);

        WebElement growthCm = driver.findElement(By.xpath("//input[@type='text']"));
        growthCm.sendKeys(growth);


        if (!driver.findElement(By.xpath("//span[@class='btn__label']")).isSelected()) {
            driver.findElement(By.xpath("//span[@class='btn__label']")).click();

        }
    }
   /* @After
    public void tearDown() {
        driver.close();
    }*/
}
