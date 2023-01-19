package org.example.stg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(linkText = "Sign in")
    private WebElement signInLink;


    public MainPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
    }

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickSignIn() {
        signInLink.click();
        return new LoginPage(driver);
    }

    public boolean isSignInPresent() {
        return isElementPresent(signInLink);
    }

}
