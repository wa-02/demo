package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Groups {

    private WebDriver driver;

    @FindBy(css = "a.create-course-btn")
    WebElement createGroupButton;

    public Groups(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateGroupPopup clickCreateGroupButton(){

        createGroupButton.click();
        return new CreateGroupPopup(driver);
    }

}