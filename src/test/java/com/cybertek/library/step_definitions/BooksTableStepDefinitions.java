package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BooksTableStepDefinitions {
    BooksPage booksPage = new BooksPage();
    @Then("books table should contain results matching {}")
    public void books_table_should_contain_results_matching(String book) {
        List<String> actualRows = BrowserUtils.getElementsText(booksPage.allRows);

        boolean found = true;
        for (String row : actualRows) {
            if (!row.toLowerCase().contains(book.toLowerCase())) {
                found = false;
            }
        }

        assertTrue(book + " was not found in books table", found);
    }



    @When("I edit book {}")
    public void i_edit_book_The_kiterunner(String book) {
        System.out.println("book = " + book);
        BrowserUtils.waitForClickability(booksPage.search, 5).sendKeys(book);
        BrowserUtils.waitForClickability(booksPage.editBook(book), 5).click();

    }

}
