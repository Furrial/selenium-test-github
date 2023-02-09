package org.example.stg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateRepositoryPage extends BasePage {
    @FindBy(id = "repository_name")
    private WebElement repoNameInput;

    @FindBy(css = "dd.error")
    private WebElement repoError;

    public CreateRepositoryPage(WebDriver driver) {
        super(driver);
    }

    public void typeRepoName(String repoName) {
        repoNameInput.sendKeys(repoName);
    }

    public String getRepoNameErrorMessage() {
        return repoError.getText();
    }

}
