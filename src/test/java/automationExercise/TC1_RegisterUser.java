package automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class TC1_RegisterUser {

    @Test
    public void register() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
        String expectedUrl="https://automationexercise.com/";
        String actualUrl=driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);

//4. Click on 'Signup / Login' button
        WebElement singupButton=driver.findElement(By.xpath("//a[@href='/login']"));
        singupButton.click();

//5. Verify 'New User Signup!' is visible
        String expectedMessage="New User Signup!";
        String actualMessage=driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        System.out.println("actualMessage = " + actualMessage);
        Assertions.assertEquals(expectedMessage,actualMessage);

//6. Enter name and email address
        String name="ncb";
        String email="ncb@test.com";

        WebElement nameInputBox=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        WebElement emailInputBox= driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        nameInputBox.sendKeys(name);
        emailInputBox.sendKeys(email);


//7. Click 'Signup' button
        WebElement singupButtonOfRegisterPage=driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        singupButtonOfRegisterPage.click();

//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String expectedMessageOfRegisterPage="ENTER ACCOUNT INFORMATION";
        String actualMessageOfRegisterPage=driver.findElement(By.xpath("//b[text()='Enter Account Information']")).getText();
        Assertions.assertEquals(expectedMessageOfRegisterPage,actualMessageOfRegisterPage);

//9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender2")).click();
        String password="12345";
        driver.findElement(By.id("password")).sendKeys(password);

        Select dropdownOfDays= new Select(driver.findElement(By.name("days")));
        dropdownOfDays.selectByVisibleText("10");

        Select dropdownOfMonths=new Select(driver.findElement(By.name("months")));
        dropdownOfMonths.selectByValue("10");

        Select dropdownOfYears=new Select(driver.findElement(By.id("years")));
        dropdownOfYears.selectByVisibleText("2000");

//10. Select checkbox 'Sign up for our newsletter!'
//11. Select checkbox 'Receive special offers from our partners!'

        /*
        List<WebElement> listOfCheckboxes=driver.findElements(By.xpath("//label[@for='newsletter']"));
        for (WebElement each : listOfCheckboxes) {
            if (!each.isSelected())
                each.click();
        }

         */


        WebElement checkboxOfNewsletter=driver.findElement(By.xpath("//label[@for='newsletter']"));

        //Actions class examples
        Actions actions=new Actions(driver);
        actions.moveToElement(checkboxOfNewsletter).click().build().perform();

        //javascript examples
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeScript("arguments[0],click();",checkboxOfNewsletter);

        WebElement checkboxOfOffers=driver.findElement(By.xpath("//label[@for='optin']"));
        //actions.moveToElement(checkboxOfOffers).click().build().perform();

//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("ncb");
        driver.findElement(By.id("last_name")).sendKeys("deneme");
        driver.findElement(By.id("address1")).sendKeys("ank");

        Select dropdownOfCountry=new Select(driver.findElement(By.id("country")));
        dropdownOfCountry.selectByVisibleText("Canada");

        driver.findElement(By.id("state")).sendKeys("ank");
        driver.findElement(By.id("city")).sendKeys("ank");
        driver.findElement(By.id("zipcode")).sendKeys("06100");
        driver.findElement(By.id("mobile_number")).sendKeys("31233333333");

//13. Click 'Create Account button'
        WebElement createAccountButton=driver.findElement(By.xpath("//button[text()='Create Account']"));
        //WebElement createAccountButton=driver.findElement(By.xpath("//input[@name='form_type']"));
        createAccountButton.click();
        //actions.moveToElement(createAccountButton).click().build().perform();
        //js.executeScript("arguments[0],click();",createAccountButton);



//14. Verify that 'ACCOUNT CREATED!' is visible
        String expectedSuccessfulMessage="ACCOUNT CREATED!";
        String actualSuccessMessage=driver.findElement(By.xpath("//b[text()='Account Created!']")).getText();
        System.out.println("actualSuccessMessage = " + actualSuccessMessage);
        Assertions.assertEquals(expectedSuccessfulMessage,actualSuccessMessage);

//15. Click 'Continue' button
        driver.findElement(By.xpath("continue-button"));

//16. Verify that 'Logged in as username' is visible
        WebElement accountInfo=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assertions.assertTrue(accountInfo.isDisplayed());

//17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();

//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String expectedDeleteMessage="ACCOUNT DELETED!";
        String actualDeleteMessage=driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText().toUpperCase();
        Assertions.assertEquals(expectedDeleteMessage,actualDeleteMessage);

        driver.findElement(By.xpath("//a[@data-qa='continue-button']"));

    }
}
