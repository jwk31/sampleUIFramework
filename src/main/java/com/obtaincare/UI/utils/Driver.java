package com.obtaincare.UI.utils;

import com.obtaincare.UI.dataProviders.ConfigReader;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Driver {

    private Driver() {
        // Singleton pattern.
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getProperty("browser").toLowerCase()) {
                default:
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFox();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                case "saucelabs":
                    try{
                        driver = SauceLabsDriver.loadSauceLabsDriver(ConfigReader.getProperty("platformName"),
                                ConfigReader.getProperty("browserName"), ConfigReader.getProperty("browserVersion"));
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
