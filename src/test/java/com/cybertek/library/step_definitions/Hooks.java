package com.cybertek.library.step_definitions;


import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUpScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().fullscreen();
    }

    @After
    public void tearDownScenario(){
        Driver.closeDriver();
    }
}
