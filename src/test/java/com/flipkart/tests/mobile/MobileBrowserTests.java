package com.flipkart.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Utility class to check mobile browser functionality using Appium
 * This example uses Android Chrome browser with Appium
 */
public class MobileBrowserCheck {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:chromedriverAutodownload", true);
        //caps.setCapability("appium:chromedriverExecutable", "/Users/dewanshun/Drivers/chromedriver-mac-arm64/chromedriver");

        // Start Appium session
        WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);

        // Interact with browser
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());

        // Close session after 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted: " + e.getMessage());
        }

        driver.quit();
    }
}
