package org.example.stg.base;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.aeonbits.owner.ConfigFactory;
import org.example.stg.config.Configuration;
import org.example.stg.pages.BasePage;
import org.example.stg.reporter.TestReporter;
import org.example.stg.util.WebDriverHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith({SeleniumJupiter.class, TestReporter.class})
public abstract class BaseTest {
    protected Configuration cfg;
    protected WebDriver driver;

    @BeforeAll
    void configure() {
        cfg = ConfigFactory.create(Configuration.class);
    }

    @BeforeEach
    void setUp(WebDriver driver) {
        driver.manage().window().maximize();
        WebDriverHelper.setDriver(driver);
        this.driver = driver;
        BasePage.setTIMEOUT(cfg.timeout());
    }

}
