import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeFormTest {

    public static final String URL = "https://demoqa.com/automation-practice-form";

    WebDriver driver = new ChromeDriver();


    @BeforeTest
    public void setWebDriver(){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        driver.manage().window().maximize();
    }

    @Test
    public void openRegistrationForm(){
        driver.get(URL);

        WebElement pageHeader = driver.findElement(By.xpath("//div[@class=\"main-header\"]"));
        String pageHeaderText = pageHeader.getText();
        Assert.assertEquals(pageHeaderText, "Practice Form");

    }

    @Test(dependsOnMethods = "openRegistrationForm")
    public void inputFirstName(){
        driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys("Имя");
        driver.findElement(By.xpath("//input[@id=\"lastName\"]")).sendKeys("Фамилия");
        driver.findElement(By.xpath("//input[@id=\"userEmail\"]")).sendKeys("example@mail.com");
        //driver.findElement(By.xpath("//input[@value=\"Male\"]//label")).click();
        driver.findElement(By.xpath("//input[@id=\"userNumber\"]")).sendKeys("0123456789");

        driver.findElement(By.xpath("//input[@id=\"dateOfBirthInput\"]")).click();
        driver.findElement(By.xpath("//select[@class=\"react-datepicker__month-select\"]")).click();
        driver.findElement(By.xpath("//option[@value=\"3\"]")).click();
        driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]")).click();
        driver.findElement(By.xpath("//option[@value=\"1994\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"react-datepicker__day react-datepicker__day--011\"]")).click();


        //driver.findElement(By.xpath("//input[@value=\"1\"]")).click();
        driver.findElement(By.xpath("//textArea[@id=\"currentAddress\"]")).sendKeys("myAddress");
        driver.findElement(By.xpath("//button[@id=\"submit\"]")).submit();
    }

    /*
    @AfterTest
    public void closeWebDriver(){
        driver.quit();
    }

     */
}
