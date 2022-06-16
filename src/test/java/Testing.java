import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testing {
    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.koltiva.com/");
    }

    @Test
    public void test(){
        String title = "About | Koltiva";
        WebElement labelAbout = driver.findElement(By.xpath("//p[@id=\"comp-keidh9zf1label\"]"));
        labelAbout.click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(title,actualTitle);
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
