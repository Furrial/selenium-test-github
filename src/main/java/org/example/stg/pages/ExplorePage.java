package org.example.stg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ExplorePage extends BasePage {
    @FindBys({@FindBy(css = ".border.rounded.color-shadow-small.color-bg-subtle.my-4")})
    private List<WebElement> articles;

    public ExplorePage(WebDriver driver) {
        super(driver);
    }

    public int getNumberOfSuggesions() {
        wait.until(ExpectedConditions.visibilityOfAllElements(articles));
        return articles.size();
    }
}
