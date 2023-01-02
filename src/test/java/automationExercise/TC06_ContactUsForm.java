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

public class TC06_ContactUsForm {

//    Test Case 6: Contact Us Form
    @Test
    public void ContactUsForm(){
//    1. Launch browser
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver=new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//    2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com");

//    3. Verify that home page is visible successfully
        Assertions.assertEquals("Automation Exercise",driver.getTitle());

//    4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

//    5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouchTitle=driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        //System.out.println(getInTouchTitle.getText());
        Assertions.assertTrue(getInTouchTitle.isDisplayed());

//    6. Enter name, email, subject and message
        WebElement nameInputBox= driver.findElement(By.name("name"));
        WebElement emailInbutBox= driver.findElement(By.name("email"));
        WebElement subjectInputBox= driver.findElement(By.name("subject"));
        WebElement messageInputBox= driver.findElement(By.name("message"));

        nameInputBox.sendKeys("TestName");
        emailInbutBox.sendKeys("ali@test.com");
        subjectInputBox.sendKeys("TC6 test");
        messageInputBox.sendKeys("test message");

//    7. Upload file
        WebElement choseFile=driver.findElement(By.name("upload_file"));
        choseFile.sendKeys("C:\\Users\\alitu\\OneDrive\\Desktop\\test.png");


//    8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='name']")).submit();

//    9. Click OK button
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        alert.accept();

//    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        String expectedSuccessMessage="Success! Your details have been submitted successfully.";
        String actualSuccessMessage=driver.findElement(By.xpath("//div[text()='Success! Your details have been submitted successfully.']")).getText();
        System.out.println("actualSuccessMessage = " + actualSuccessMessage);

        Assertions.assertEquals(expectedSuccessMessage,actualSuccessMessage);

//    11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//span[.=' Home']")).click();

    }
}
