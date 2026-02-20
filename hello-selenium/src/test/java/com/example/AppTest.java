package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testGoogleHomePage() {
        // Automatically download and setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Verify the title is "Google"
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);
            assertEquals("Google", pageTitle, "Title should be Google");
        } finally {
            // Close the browser after test
            driver.quit();
        }
    }
}
