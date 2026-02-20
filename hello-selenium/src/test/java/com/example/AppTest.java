package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testGoogleHomePage() {
        // Setup ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Use headless Chrome for Jenkins / CI servers
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run without GUI
        options.addArguments("--no-sandbox"); // Required for Linux Jenkins
        options.addArguments("--disable-dev-shm-usage"); // Avoid memory issues
        options.addArguments("--disable-gpu"); // Optional but recommended
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Verify page title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);
            assertEquals("Google", pageTitle, "Title should be Google");
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
