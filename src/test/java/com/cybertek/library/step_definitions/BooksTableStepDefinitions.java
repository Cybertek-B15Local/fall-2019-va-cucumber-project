package com.cybertek.library.step_definitions;

import com.cybertek.library.pages.BooksPage;
import com.cybertek.library.pojos.Book;
import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.DBUtils;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
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


    @When("I edit/open book {}")
    public void i_edit_book_The_kiterunner(String book) {
        System.out.println("book = " + book);
        BrowserUtils.waitForClickability(booksPage.search, 5).sendKeys(book);
        BrowserUtils.waitForClickability(booksPage.editBook(book), 5).click();

    }

    // register a data table type that uses a custom class
    @DataTableType
    public Book convertBook(Map<String, String> dataTable) {
        Book book = new Book(dataTable.get("name"),
                dataTable.get("author"),
                dataTable.get("year"));
        return book;
    }

    @Then("I verify book information")
    public void i_verify_book_information(Book book) {
        System.out.println(book);
        System.out.println("book.getName() = " + book.getName());
        System.out.println("book.getAuthor() = " + book.getAuthor());
        System.out.println("book.getYear() = " + book.getYear());

        assertEquals("Book name did not match",
                book.getName(), booksPage.bookName.getAttribute("value"));
        assertEquals("Book author did not match",
                book.getAuthor(), booksPage.author.getAttribute("value"));
        assertEquals("Book year did not match",
                book.getYear(), booksPage.year.getAttribute("value"));
    }

    @Then("book information must match the database for {}")
    public void book_information_must_match_the_database_for_The_kite_runner(String book) {
        String aName = booksPage.bookName.getAttribute("value");
        String aAuthor = booksPage.author.getAttribute("value");
        String aYear = booksPage.year.getAttribute("value");
        String aIsbn = booksPage.isbn.getAttribute("value");
        String aDescription = booksPage.description.getAttribute("value");
        String aCategory = booksPage.categoryList().getFirstSelectedOption().getText();

        // get the expected book info from the database
        String sql = "SELECT b.isbn, b.year, b.author, bc.name, b.description\n" +
                "FROM books b\n" +
                "JOIN book_categories bc\n" +
                "ON b.book_category_id = bc.id\n" +
                "WHERE b.name = '" + book + "';";
        System.out.println(sql);
        Map<String, Object> dbData = DBUtils.getRowMap(sql);
        System.out.println(dbData);

        DBUtils.getColumnNames(sql);

        String eAuthor = dbData.get("author").toString();
        String eYear = dbData.get("year").toString();
        String eIsbn = dbData.get("isbn").toString();
        String eDescription = dbData.get("description").toString();
        String eCat = dbData.get("name").toString();

        assertEquals("author did not match", eAuthor, aAuthor);
        assertEquals("year did not match", eYear, aYear);
        assertEquals("isbn did not match", eIsbn, aIsbn);
        assertEquals("desctiption did not match", eDescription, aDescription);
        assertEquals("category did not match", eCat, aCategory);


    }

    @Then("book categories must match book_categories table from db")
    public void book_categories_must_match_book_categories_table_from_db() {
        // get the expected categories from the database as a list
        String sql = "SELECT name FROM book_categories;";
        List<Object> namesObj = DBUtils.getColumnData(sql, "name");
        List<String> exNames = new ArrayList<>();
        for (Object o : namesObj) {
            exNames.add(o.toString());
        }
        System.out.println(exNames);
        // get the actual categories from UI as webelements
        // convert the web elements to list
        booksPage.categoryList()

        // compare 2 lists
    }


}
