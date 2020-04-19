package com.cybertek.library.pages;

import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageBase {
    public PageBase() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
