package automationExercise;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


//        Test Case 3: Login User with incorrect email and password
public class TC3_LoginUserWithInvalidCredentials {


    @Test
    public void loginWithInvalidCredentials(){

//1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");


//3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();
        //System.out.println("actualTitle = " + actualTitle);

        Assertions.assertEquals(expectedTitle,actualTitle);


//4. Click on 'Signup / Login' button
        WebElement signupButton=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signupButton.click();


//5. Verify 'Login to your account' is visible



//        6. Enter incorrect email address and password
//        7. Click 'login' button
//        8. Verify error 'Your email or password is incorrect!' is visible


    }
}
