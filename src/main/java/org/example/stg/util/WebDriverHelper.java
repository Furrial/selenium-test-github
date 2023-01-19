package org.example.stg.util;

import lombok.extern.slf4j.Slf4j;
import org.example.stg.constant.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class WebDriverHelper {
    private static ThreadLocal<WebDriver> holder = new ThreadLocal<>();

    private WebDriverHelper() {
    }

    public static void setDriver(WebDriver driver) {
        holder.set(driver);
    }

    public static String takeScreenshot() {
        File screen, storedScreen;
        if (holder.get().getClass().isAssignableFrom(ChromeDriver.class)) {
            screen = ((ChromeDriver) holder.get()).getScreenshotAs(OutputType.FILE);
        } else if (holder.get().getClass().isAssignableFrom(FirefoxDriver.class)) {
            screen = ((FirefoxDriver) holder.get()).getScreenshotAs(OutputType.FILE);
        } else {
            throw new RuntimeException("Not supported browser for screenshoting");
        }

        try {
            storedScreen = new File(Path.PATH_AND_NAME_OF_SCREENSHOT + LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh_mm_ss")) + ".png");
            FileHandler.copy(screen, storedScreen);
            log.info("-------- SCREENSHOOT SAVED --------");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return storedScreen.getName();
    }
}
