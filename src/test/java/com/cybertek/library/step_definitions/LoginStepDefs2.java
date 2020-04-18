package com.cybertek.library.step_definitions;

import io.cucumber.java.en.When;

public class LoginStepDefs2 {

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        System.out.println(username);
    }

    @When("I enter password {string}")
    public void i_enter_password(String string) {
        System.out.println(string);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        System.out.println("Clicking on sign in");
    }


}
