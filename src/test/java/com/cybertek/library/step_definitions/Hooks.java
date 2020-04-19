package com.cybertek.library.step_definitions;


import com.cybertek.library.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before(order = 0)
    public void setUpScenario() {
        System.out.println("set up browser");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().fullscreen();
    }

    @Before(value = "@db", order = 1)
    public void connect(){
        System.out.println("connecting to db");
    }

    @After
    public void tearDownScenario() {
        System.out.println("close driver");
        Driver.closeDriver();
    }

    @After("@db")
    public void closeConnection() {
        System.out.println("closing connection to db");
    }


//    @BeforeStep
    public void setUpStep() {
        System.out.println("prints before every step");
    }

//    @AfterStep
    public void tearDownStep(){
        System.out.println("prints after every step");
    }

}