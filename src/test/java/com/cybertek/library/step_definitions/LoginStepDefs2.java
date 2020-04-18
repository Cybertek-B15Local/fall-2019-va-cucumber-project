package com.cybertek.library.step_definitions;

import io.cucumber.java.en.When;

public class LoginStepDefs2 {

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        System.out.println("Enter username: "+username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        System.out.println("Enter password: "+password);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        System.out.println("Clicking on sign in button");
    }
}
