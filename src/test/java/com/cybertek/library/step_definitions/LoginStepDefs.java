package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utilities.ConfigurationReader;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.LibraryConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        String url = null;
        if (System.getProperty("env") != null) {
            url = ConfigurationReader.getProperty(System.getProperty("env")+"_url");

        } else {
            url = ConfigurationReader.getProperty("url");
        }

        System.out.println("Going to the login page");
        // login
        // Driver.getDriver()  --> gives us a driver object
        Driver.getDriver().get(url);

    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        System.out.println("Logging in as a librarian");
        String email = ConfigurationReader.getProperty("librarian_email");
        String password = ConfigurationReader.getProperty("librarian_password");
        loginPage.login(email, password);
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        System.out.println("Verifying dashboard page");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        wait.until(ExpectedConditions.urlContains("dashboard"));
        String actualTitle = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualTitle.endsWith("dashboard"));
    }

    @When("I login as a student")
    public void i_login_as_a_student() {
        System.out.println("Logging in as a student");
        String email = ConfigurationReader.getProperty("student_email");
        String password = ConfigurationReader.getProperty("student_password");
        loginPage.login(email, password);
    }

    @When("I login as an admin")
    public void i_login_as_a_admin() {
        System.out.println("Logging in as an admin");
    }


    @Given("I login using following credentials:")
    public void i_login_using_following_credentials(Map<String, String> credentials) {
        System.out.println(credentials);
        String email = credentials.get("email");
        String password = credentials.get("password");
        System.out.println("email = " + email);
        System.out.println("password = " + password);

        loginPage.login(email, password);
    }



    @Given("I login to application as a {word}")
    public void i_login_to_application_as_a(String user) throws Exception {
        String email = null, password = null;
        switch (user.toLowerCase()) {
            case LibraryConstants.LIBRARIAN:
                email = ConfigurationReader.getProperty("librarian_email");
                password = ConfigurationReader.getProperty("librarian_password");
                break;
            case LibraryConstants.STUDENT:
                email = ConfigurationReader.getProperty("student_email");
                password = ConfigurationReader.getProperty("student_password");
                break;
            default:
//                Assert.fail("Wrong user type is provided: "+user);
                throw new Exception("Wrong user type is provided: "+user);
        }
        loginPage.login(email, password);
    }

}
