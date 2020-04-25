package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.UsersPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class UsersTableStepDefs {
    UsersPage usersPage = new UsersPage();

    @When("I search for {string}")
    public void i_search_for(String searchString) {
        BrowserUtils.waitForClickability(usersPage.search, 5);
        usersPage.search.sendKeys(searchString);
        BrowserUtils.wait(1);
    }

    @Then("table should contain rows with {string}")
    public void table_should_contain_rows_with(String expectedString) {

        int size = usersPage.allUserIds.size();
        for (int i = 0; i < size; i++) {
            String id = usersPage.allUserIds.get(i).getText().toLowerCase();
            String name = usersPage.allFullNames.get(i).getText().toLowerCase();
            String email = usersPage.allEmails.get(i).getText().toLowerCase();

            System.out.println("ROW: " + (i + 1));
            System.out.println(id + "\t" + name + "\t" + email);

            boolean found = id.contains(expectedString) ||
                    name.contains(expectedString) ||
                    email.contains(expectedString);
            assertTrue("Expedted string was not found in table: "+expectedString, found);
        }

    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnsNames) {
        System.out.println(expectedColumnsNames);
        List<String> actualColumnsNames = BrowserUtils.getElementsText(usersPage.columnNames);
        assertEquals(expectedColumnsNames, actualColumnsNames);

    }


    @Then("table should contain this data")
    public void table_should_contain_this_data(Map<String, String> user) {
        System.out.println(user.entrySet());

        String name = user.get("Full Name");
        String email = user.get("Email");
        String id = user.get("User ID");
        System.out.println("name = " + name);
        System.out.println("email = " + email);
        System.out.println("id = " + id);

        // get all rows. verify that at least one of the rows contains all of the user info
        List<WebElement> allRows = usersPage.allRows;
        List<String> allRowsTxt = BrowserUtils.getElementsText(allRows);

        boolean found = true;
        for (String row : allRowsTxt) {
            System.out.println("row = " + row);
            found = row.contains(id) &&
                    row.contains(name) &&
                    row.contains(email);
            if (found) {
                break;
            }
        }
        assertTrue(user + " was not found", found);
    }

    @Then("Each user id should be unique")
    public void each_user_id_should_be_unique() {
        usersPage.getShowRecords().selectByVisibleText("500");
        BrowserUtils.wait(1);

        List<String> list = BrowserUtils.getElementsText(usersPage.allUserIds);
        System.out.println(list);

        Set<String> set = new HashSet<>(list);
        System.out.println(set);

        assertEquals(list.size(), set.size());

    }



}
