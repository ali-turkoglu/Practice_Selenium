package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//Test Case 2: Login User with correct email and password
public class TC2_LoginUserWithValidCredential {

    @Test
    public void LoginUserWithValidCredential(){

        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement homePageImage=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@alt='Website for automation practice']"))));
        Assertions.assertTrue(homePageImage.isDisplayed());

        //4. Click on 'Signup / Login' button

        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        //7. Click 'login' button
        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Delete Account' button
        //10. Verify that 'ACCOUNT DELETED!' is visible

    }



}
