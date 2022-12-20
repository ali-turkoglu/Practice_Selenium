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
import pages.HomePage;
// We usually should use Driver.getDriver() instead of driver object and we also should create our WebElements into the page
//folders to increase reusability.
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
        driver.findElement(By.xpath("//a[@href='/login']")).click();


        //5. Verify 'Login to your account' is visible
        WebElement loginTitle=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        loginTitle.isDisplayed();

        //6. Enter correct email address and password
        String userName="ali@test.com";
        String password="12345";
        WebElement emailInputBox=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement passwordInputBox= driver.findElement(By.xpath("//input[@data-qa='login-password']"));



        emailInputBox.sendKeys(userName);
        passwordInputBox.sendKeys(password);


        //7. Click 'login' button
        WebElement loginButton= driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        WebElement nameOfLoggedUsername= driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        String expectedText="Logged in as ali";

        Assertions.assertEquals(expectedText,nameOfLoggedUsername.getText());

        //9. Click 'Logout' button
        WebElement logoutLink= driver.findElement(By.xpath("//a[@href='/logout']"));
        logoutLink.click();

        //10. Verify that currenturl is 'https://automationexercise.com/login'
        String currentUrl="https://automationexercise.com/login";
        Assertions.assertTrue(driver.getCurrentUrl().equals(currentUrl));

    }



}
