package hooks;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import base.BaseClass;
import io.cucumber.java.Scenario;

import java.io.File;
import java.nio.file.Files;

public class Hooks extends BaseClass {

    //This Line is for testing commit working or not & visible on the commit history locally

    @Before //Common before all scenario
    public void setup(Scenario scenario) {

        System.out.println("Scenarion Start: "+ scenario.getName());
        loadConfig();
        browser_launch();
        browser_openURL();

    }

    @Before ("@smoke") // before only smoke scenarios
    public void beforeSmoke(){

        System.out.println("=========Running Smoke Test=========");
    }

    @Before ("@regression") // before only regression scenarios
    public void beforeRegression(){

        System.out.println("=========Running Regression Test=========");
    }


    @After
    public void tearDown(Scenario scenario) {

        // Check whether the scenario failed
        if (scenario.isFailed()) {

            // Take screenshot and get its file path
            String imgPath = captureScreen(scenario.getName());

            try {

                // Read screenshot file as bytes
                byte[] screenshot = Files.readAllBytes(
                        new File(imgPath).toPath()
                );

                /*// Attach screenshot to Cucumber report
                scenario.attach(
                        screenshot,
                        "image/png",
                        "Failed Screenshot"
                );*/

                // Attach screenshot to Extent Report
                ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(
                        "screenshots/" + new File(imgPath).getName()
                );

            } catch (Exception e) {

                // Print error if screenshot attachment fails
                e.printStackTrace();
            }
        }

        // Close browser after scenario
        browser_close();
    }




}