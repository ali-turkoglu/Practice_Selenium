package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;

public class TC4_LogoutUser {


//Test Case 4: Logout User
    @Test
    public void logoutUser(){

//1. Launch browser
        //        WebDriverManager.chromedriver().setup();
        //        WebDriver driver=new ChromeDriver();
        //        driver.manage().window().maximize();
        //        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        Assertions.assertEquals("Automation Exercise",Driver.getDriver().getTitle());

//4. Click on 'Signup / Login' button
        Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-lock']")).click();

//5. Verify 'Login to your account' is visible
        Assertions.assertTrue(Driver.getDriver().findElement(By.xpath("//h2[.='Login to your account']")).isDisplayed());

//6. Enter correct email address and password
        Driver.getDriver().findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(ConfigurationReader.getProperty("email"));
        Driver.getDriver().findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys(ConfigurationReader.getProperty("password"));

//7. Click 'login' button
        Driver.getDriver().findElement(By.xpath("//button[@data-qa='login-button']")).submit();

//8. Verify that 'Logged in as username' is visible
        Assertions.assertTrue(Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-user']")).isDisplayed());

//9. Click 'Logout' button
        Driver.getDriver().findElement(By.xpath("//i[@class='fa fa-lock']")).click();

//10. Verify that user is navigated to login page
        String expectedTitle="Automation Exercise - Signup / Login";
        Assertions.assertEquals(expectedTitle,Driver.getDriver().getTitle());



    }

}
