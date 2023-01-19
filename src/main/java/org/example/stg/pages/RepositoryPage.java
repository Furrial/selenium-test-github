package org.example.stg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RepositoryPage extends BasePage {

    @FindBy(css = "strong>a")
    private WebElement repoName;

    public RepositoryPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.elementToBeClickable(repoName));
    }

    public String getRepoName() {
        return repoName.getText();
    }
}
