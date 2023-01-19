package org.example.stg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(name = "login")
    private WebElement login;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "commit")
    private WebElement commit;

    @FindBy(className = "js-flash-alert")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public UserHomePage loginCorrect(String username, String password) {
        login(username, password);
        return new UserHomePage(driver);
    }

    public String loginWithError(String username, String password) {
        login(username, password);
        return errorMessage.getText().trim();
    }

    private void login(String username, String password) {
        this.login.sendKeys(username);
        this.password.sendKeys(password);
        this.commit.click();
    }


}
