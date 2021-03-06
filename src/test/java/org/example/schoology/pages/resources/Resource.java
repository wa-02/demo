package org.example.schoology.pages.resources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.example.core.ui.AbstractPage;

public class Resource extends AbstractPage {

    @FindBy(css = "#collection-view")
    private WebElement collectionView;

    public Resource() {
        wait.until(ExpectedConditions.visibilityOf(collectionView));
    }
}
