package org.example.stg;

import org.example.stg.base.BaseTest;
import org.example.stg.pages.LoginPage;
import org.example.stg.pages.MainPage;
import org.example.stg.pages.RepositoryPage;
import org.example.stg.pages.UserHomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepositoryTest extends BaseTest {
    UserHomePage userHomePage;

    @BeforeEach
    void login() {
        MainPage mainPage = new MainPage(driver, cfg.testAppUrl());
        LoginPage loginPage = mainPage.clickSignIn();
        userHomePage = loginPage.loginCorrect(cfg.username(), cfg.password());
    }

    @Test
    @DisplayName("junit5 repo search test")
    void testSearchForRepo() {
        String repoToSearch = "junit5";
        RepositoryPage repositoryPage = userHomePage.searchForRepo(repoToSearch).clickFirstLink();
        assertEquals("junit5", repositoryPage.getRepoName());
    }

}
