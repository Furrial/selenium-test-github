package org.example.stg;

import org.example.stg.base.BaseTest;
import org.example.stg.pages.LoginPage;
import org.example.stg.pages.MainPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthenticateValidationTest extends BaseTest {
    private static final String INCORRECT = "wrong";
    private static final String ERROR_MESSAGE = "Incorrect username or password.";

    @Test
    void testLoginToGitHub_IncorrectLogin() {
        MainPage mainPage = new MainPage(driver, cfg.testAppUrl());
        LoginPage loginPage = mainPage.clickSignIn();
        String actual = loginPage.loginWithError(INCORRECT, cfg.password());
        assertEquals(actual, ERROR_MESSAGE);
    }

    @Test
    void testLoginToGitHub_IncorrectPassword() {
        MainPage mainPage = new MainPage(driver, cfg.testAppUrl());
        LoginPage loginPage = mainPage.clickSignIn();
        String actual = loginPage.loginWithError(cfg.username(), INCORRECT);
        assertEquals(actual, ERROR_MESSAGE);
    }
}
