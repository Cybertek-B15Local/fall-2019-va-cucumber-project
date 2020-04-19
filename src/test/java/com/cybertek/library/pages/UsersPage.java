package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UsersPage extends PageBase {
    @FindBy (name = "tbl_users_length")
    public WebElement showRecords;

    public Select getShowRecords(){
        return new Select(showRecords);
    }
}
