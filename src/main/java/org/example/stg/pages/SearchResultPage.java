package org.example.stg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class SearchResultPage extends BasePage {
    @FindBys({@FindBy(css = "a.v-align-middle")})
    private List<WebElement> repositoriesLinks;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public RepositoryPage clickFirstLink() {
        repositoriesLinks.get(0).click();
        return new RepositoryPage(driver);
    }
}
