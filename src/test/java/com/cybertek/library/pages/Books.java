package com.cybertek.library.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Books extends PageBase {

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(tagName = "input")
    public WebElement search;
}
