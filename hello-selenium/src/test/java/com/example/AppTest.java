package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;

public class AppTest {

    @Test
    public void testGoogleHomePage() {
        WebDriverManager.chromedriver().setup();

        // Headless Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://www.google.com");

            // Wait until title contains "Google" (explicit wait)
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Google"));

            // Verify the title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);
            assertEquals("Google", pageTitle, "Title should be Google");
        } finally {
            driver.quit();
        }
    }
}
