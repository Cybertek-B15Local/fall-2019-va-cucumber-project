package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersTableStepDefs {
    UsersPage usersPage = new UsersPage();

    @When("I search for {string}")
    public void i_search_for(String searchString) {
        usersPage.search.sendKeys(searchString);
    }

    @Then("table should contain rows with {string}")
    public void table_should_contain_rows_with(String string) {

        int size = usersPage.allUserIds.size();
        for (int i = 0; i < size; i++) {
            String id = usersPage.allUserIds.get(i).getText();
            String name = usersPage.allFullNames.get(i).getText();
            String email = usersPage.allEmails.get(i).getText();

            System.out.println("ROW: " + (i + 1));
            System.out.println(id + "\t" + name + "\t"+email);
        }

    }

}
