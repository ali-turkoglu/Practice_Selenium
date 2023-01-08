package others;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.io.File;
import java.time.Duration;

public class Creating_Profiles {

    public static void main(String[] args) {

        ProfilesIni profilesIni=new ProfilesIni();

        FirefoxOptions options=new FirefoxOptions();
        options.setProfile(profilesIni.getProfile("profile"));

        FirefoxProfile profile= new FirefoxProfile(new File("C:\\Users\\alitu\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\6b70q868.profile"));


        // windows+R --> firefox.exe -p --> create profile named "testProfile"
        //FirefoxProfile myprofile=profilesIni.getProfile("testProfile");

        WebDriver driver=new FirefoxDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("www.google.com");


    }
}
