package automation_practice.hooks;

import automation_practice.browsers.Driver;
import cucumber.api.java.After;

public class BeforeAfterSteps {

    public void beforeMethod() {
        Driver.runDriver();
    }

    @After
    public void afterMethod(){
        Driver.quitDriver();
    }
}