package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.DashBoardPage;
import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import com.cybertek.library.utilities.LibraryConstants;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageNavigationStepDefs {
    DashBoardPage dashBoardPage = new DashBoardPage();
    UsersPage usersPage = new UsersPage();


    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        switch (link.toLowerCase()) {
            case "dashboard":
                dashBoardPage.dashboard.click();
                break;
            case "users":
                dashBoardPage.users.click();
                break;
            case "books":
                dashBoardPage.books.click();
                break;
        }
    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String page) {
        BrowserUtils.wait(1);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith(page.toLowerCase()));
        switch (page.toLowerCase()) {
            case "users":
                String actual = dashBoardPage.pageHeader.getText();
                Assert.assertEquals("User Management", actual);
                break;
            case "books":
                actual = dashBoardPage.pageHeader.getText();
                Assert.assertEquals("Book Management", actual);
                break;
        }
    }


    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer selected) {
        System.out.println("selected = " + selected);
        String actual = usersPage.getShowRecords().getFirstSelectedOption().getText();
        Assert.assertEquals(selected + "", actual);

    }

    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {
        System.out.println("options.size() = " + options.size());
        System.out.println(options);
        List<WebElement> webElements = usersPage.getShowRecords().getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(webElements);
        Assert.assertEquals(options, elementsText);

    }

    @When("I select Show {int} records")
    public void i_select_Show_records(Integer option) {
        usersPage.getShowRecords().selectByVisibleText(option.toString());
    }

    @Then("the users table must display {int} records")
    public void the_users_table_must_display_records(int expectedCount) {
        BrowserUtils.wait(1);
        int actualCount = usersPage.allRows.size();
        Assert.assertEquals(expectedCount, actualCount);

    }

    @When("I go/navigate to {string} page")
    public void i_go_to_page(String page) {
        System.out.println("Going to page " + page);
        switch (page.toLowerCase()) {
            case LibraryConstants.DASHBOARD:
                dashBoardPage.dashboard.click();
                break;
            case LibraryConstants.USERS:
                dashBoardPage.users.click();
                break;
            case LibraryConstants.BOOKS:
                dashBoardPage.books.click();
                break;
        }
    }

}
