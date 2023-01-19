package org.example.stg.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.example.stg.constant.Path.PATH_AND_NAME_OF_SCREENSHOT;

public class UserHomePage extends BasePage {

    @FindBy(xpath = "//h2/a[@href = '/new']")
    private WebElement newRepositoryLink;

    @FindBy(name = "q")
    private WebElement quickSearchInput;

    @FindBy(xpath = "//summary[@aria-label='View profile and more']")
    private WebElement profileOptions;
    @FindBy(css = "form.logout-form")
    private WebElement logOut;

    @FindBy(css = "a[data-ga-click~='item:explore']")
    private WebElement exploreLink;


//    @FindBys({@FindBy(name = "q")})
//    private List<WebElement> quickSearchResults;

    public UserHomePage(WebDriver driver) {
        super(driver);

        By UPDATES_FEED = By.cssSelector(".d-flex.flex-items-baseline.py-4");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((UPDATES_FEED)));
    }

    public boolean isNewRepoLinkDisplayed() {
        return isElementPresent(newRepositoryLink);
    }

    public void takeScreenshotOfNewRepoLink() {
        File screen = newRepositoryLink.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screen, new File(PATH_AND_NAME_OF_SCREENSHOT + LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh_mm_ss")) + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SearchResultPage searchForRepo(String repo) {
        quickSearchInput.sendKeys(repo);
        quickSearchInput.sendKeys(Keys.ENTER);
        return new SearchResultPage(driver);
    }

    public MainPage logOut() {
        profileOptions.click();
        logOut.click();
        return new MainPage(driver);
    }

    public ExplorePage clickExploreLink() {
        exploreLink.click();
        return new ExplorePage(driver);
    }

    public CreateRepositoryPage clickCreateNewRepo() {
        newRepositoryLink.click();
        return new CreateRepositoryPage(driver);
    }
}
