package org.example.schoology.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractResourcePopup {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = "#edit-title")
    private WebElement questionBankNameTextField;

    @FindBy(css = "#edit-description")
    private WebElement questionBankDescriptionTextField;

    @FindBy(css = "#edit-enable-tracking")
    private WebElement questionBankEnableTrackingCheckBox;

    @FindBy(css = "input[value='Create'")
    protected  WebElement submitButton;

    public AbstractResourcePopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);

    }
    public void setName(String name) {
        questionBankNameTextField.sendKeys(name);
    }

    public void setDescription(String description) {
        questionBankDescriptionTextField.sendKeys(description);
    }

    public void fill(Map<String, String> resourceMap, String enableQuestionTracking) {
        Map<String, Step> stepsMap = new HashMap<>();
        stepsMap.put("name", () -> setName(resourceMap.get("name")));
        stepsMap.put("description", () -> setDescription(resourceMap.get("description")));

        switch(enableQuestionTracking) {
            case "True":
                questionBankEnableTrackingCheckBox.click();
                break;
        }

        for (String keyField : resourceMap.keySet()) {
            stepsMap.get(keyField).execute();
        }
    }
}