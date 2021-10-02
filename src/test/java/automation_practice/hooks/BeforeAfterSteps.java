package automation_practice.hooks;

import automation_practice.browsers.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import screenshots.MakeScreenShots;

public class BeforeAfterSteps {

    private MakeScreenShots makeScreenShots;

    public void beforeMethod() {
        Driver.runDriver();
    }
    @AfterStep
    public void afterStepScreenshot(Scenario scenario){
       makeScreenShots.makeAShot(scenario.getName());
    }

    @After
    public void afterMethod(){
        Driver.quitDriver();
    }
}