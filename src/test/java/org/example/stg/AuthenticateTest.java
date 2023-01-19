package org.example.stg;

import org.example.stg.base.BaseTest;
import org.example.stg.pages.LoginPage;
import org.example.stg.pages.MainPage;
import org.example.stg.pages.UserHomePage;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
public class AuthenticateTest extends BaseTest {

    @TestTemplate //will be executed with multiple browsers (based on selenium-jupiter docs)
    void testLoginToGitHub() {
        MainPage mainPage = new MainPage(driver, cfg.testAppUrl());
        LoginPage loginPage = mainPage.clickSignIn();
        UserHomePage userHomePage = loginPage.loginCorrect(cfg.username(), cfg.password());
        assertTrue(userHomePage.isNewRepoLinkDisplayed());
    }

    @Test
    void testLogOutFromGitHub() {
        MainPage mainPage = new MainPage(driver, cfg.testAppUrl());
        LoginPage loginPage = mainPage.clickSignIn();
        UserHomePage userHomePage = loginPage.loginCorrect(cfg.username(), cfg.password());
        mainPage = userHomePage.logOut();
        assertTrue(mainPage.isSignInPresent());
    }

}
