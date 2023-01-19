package org.example.stg;

import org.example.stg.base.BaseTest;
import org.example.stg.pages.ExplorePage;
import org.example.stg.pages.LoginPage;
import org.example.stg.pages.MainPage;
import org.example.stg.pages.UserHomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.Stopwatch;

import static org.assertj.core.api.Assertions.assertThat;

public class ExploreTest extends BaseTest {
    UserHomePage userHomePage;

    @BeforeEach
    void login() {
        MainPage mainPage = new MainPage(driver, cfg.testAppUrl());
        LoginPage loginPage = mainPage.clickSignIn();
        userHomePage = loginPage.loginCorrect(cfg.username(), cfg.password());
    }

    @Stopwatch
    @Test
    void testShowExploreRepo() {
        ExplorePage explore = userHomePage.clickExploreLink();
        assertThat(explore.getPageTitle()).contains("Explore");
        assertThat(explore.getNumberOfSuggesions()).isGreaterThan(10);
    }
}
