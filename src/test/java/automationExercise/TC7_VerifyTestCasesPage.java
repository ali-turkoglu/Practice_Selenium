package automationExercise;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//without singleton design pattern for driver obj
public class TC7_VerifyTestCasesPage {

    @Test
    public void verifyTestCasesPage() throws InterruptedException {

//1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("https://automationexercise.com");

//3. Verify that home page is visible successfully
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualTitle = js.executeScript("return document.title").toString();
        Assertions.assertEquals("Automation Exercise", actualTitle);
        Assertions.assertTrue(js.executeScript("return document.title").equals("Automation Exercise"));

//4. Click on 'Test Cases' button
        WebElement testCaseButton = driver.findElement(By.xpath("//a[text()=' Test Cases']"));
        testCaseButton.click();

//5. Verify user is navigated to test cases page successfully
        //String expectedHeader = "TEST CASES";
        //String actualHeader = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        Assertions.assertTrue(driver.findElement(By.xpath("//h2[@class='title text-center']")).isDisplayed());

    }
}
