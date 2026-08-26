package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.Properties;

public class BaseClass {


    public static WebDriver driver;

   //public static String base_url = "https://www.saucedemo.com/"; //hardcoded url

    //Properties object jo config.properties file read karage
    public static Properties prop ;

    //Ye Method config.properties file load karega
    public void loadConfig(){

        try{
            prop = new Properties(); // Properties Class ka object banaya hai
            FileInputStream fis = new FileInputStream("src/main/resources/config/config.properties"); //gave path of config.properties
            prop.load(fis); //Loading Property file
        }

        catch (Exception e){

            e.printStackTrace(); // If file not found or any other issue, then it will print the stack trace
        }

    }//T

    public void browser_launch(){

        //driver = new ChromeDriver(); //Hard coded
        //Now, Reading browser name from the config.properties file //Example: browser=chrome
        String broswerName = prop.getProperty("browser");

        if (broswerName.equalsIgnoreCase("chrome")){

            driver = new ChromeDriver();
        } else if (broswerName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        } else {

            System.out.println("Browser not Supported");
        }


        driver.manage().window().maximize();

    }

    public void browser_openURL(){

        driver.get(prop.getProperty("url"));
    }


    //Common PageFactory init Method //onetime write in base class
    // Built in mechanism of selenium which can automatically initialize(find) web elements and make POM clean
    //Simple words : ek helper jo @FindBy se elements ko driver ke saath connect kar deta hai.
    public void initPageFactory(Object page) { //Name can be anything

        PageFactory.initElements(driver, page);
    }

    //Capture screen method to take ss when our testcase fails
    public String captureScreen(String testName) {

        // Location where screenshot will be saved
        String path = "ExtentReport/screenshots/" + testName + ".png";

        try {

            // Take screenshot of current browser
            File src = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            // Create destination using our path
            File dest = new File(path);

            // Create folder if it doesn't exist
            dest.getParentFile().mkdirs();

            // Copy screenshot to destination
            Files.copy(src.toPath(), dest.toPath());

            // Return screenshot path
            return path;

        } catch (Exception e) {

            // Print error if screenshot fails
            e.printStackTrace();

            // Return nothing
            return null;
        }
    }






    public void browser_close(){ //Closes the all browser window and tabs opened by the WebDriver instance

        if (driver!=null ){ // Checking driver don't point to null

            driver.quit(); //This quit method, along with the close method
            // belongs to the Chrome driver class, which has nothing to do with the base class.
            // That is an instance method so it needs the WebDriver instance to run it.

        }


    }

}
