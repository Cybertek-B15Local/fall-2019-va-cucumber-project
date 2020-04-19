package com.cybertek.library.step_definitions;


import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUpScenario() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().fullscreen();
    }

    @After
    public void tearDownScenario() {
        Driver.closeDriver();
    }

    @BeforeStep
    public void setUpStep() {
        System.out.println("prints before every step");
    }

    @AfterStep
    public void step(){
        System.out.println("prints after every step");
    }

}