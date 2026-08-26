package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//RunWith annotation ka use karke bol rahe hain ki is class ko Cucumber ke saath run karo
@RunWith (Cucumber.class) // Outside the class


@CucumberOptions( //Cucumber's control panel

 features = "src/test/resources/features/Sl_Login.feature",
 glue = {"stepDefinition","hooks" },

// ye plugins batate hain ki report ka format Kya hoga.
// pretty -> console output ko readable banata hai
// HTML -> html report generate karta hain target folder me
    plugin = { "pretty", "html:target/cucumber-report.html",
            "json:target/cucumber.json",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },

 monochrome = true,

tags = "@feature_login" //We Are controling grouping from here which to execute

// Can change above : @regression / @login / @Smoke / @login or @smoke /  @smoke and @login /


)

public class Sl_TestRunner {

 //should be blank
}
