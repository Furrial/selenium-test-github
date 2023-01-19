package org.example.stg;

import org.example.stg.base.BaseTest;
import org.example.stg.pages.CreateRepositoryPage;
import org.example.stg.pages.LoginPage;
import org.example.stg.pages.MainPage;
import org.example.stg.pages.UserHomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RepositoryValidationTest extends BaseTest {
    UserHomePage userHomePage;

    @BeforeEach
    void login() {
        MainPage mainPage = new MainPage(driver, cfg.testAppUrl());
        LoginPage loginPage = mainPage.clickSignIn();
        userHomePage = loginPage.loginCorrect(cfg.username(), cfg.password());
    }

    @Disabled("Only works for concrete user, depends on data")
    @Test
    void testCreateAlreadyExistingRepo() {
        final String ALREADY_EXISTING_REPO = "TAM2016";
        CreateRepositoryPage newRepoPage = userHomePage.clickCreateNewRepo();
        newRepoPage.typeRepoName(ALREADY_EXISTING_REPO);
        assertThat(newRepoPage.getRepoNameErrorMessage()).isEqualTo(String.format("The repository %s already exists on this account.", ALREADY_EXISTING_REPO));
    }
}
