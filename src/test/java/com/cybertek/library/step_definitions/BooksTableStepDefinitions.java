package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BooksTableStepDefinitions {
    BooksPage booksPage = new BooksPage();
    @Then("books table should contain results matching {word}")
    public void books_table_should_contain_results_matching(String book) {
        List<String> actualRows = BrowserUtils.getElementsText(booksPage.allRows);

        boolean found = true;
        for (String row : actualRows) {
            if (!row.contains(book)) {
                found = false;
            }
        }

        assertTrue(book + " was not found in books table", found);
    }
}
