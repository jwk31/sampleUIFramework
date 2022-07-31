package com.obtaincare.UI.utils;

import com.obtaincare.UI.dataProviders.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsDriver {

    public static WebDriver loadSauceLabsDriver(String platformName, String browserType, String browserVersion){

//        final String USERNAME = "oauth-jwk103110-478f0";
//        final String ACCESS_KEY = "be82f2c3-1195-41ee-86e4-15db96a5df51";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("browserName", browserType);
        capabilities.setCapability("browserVersion", browserVersion);
        WebDriver driver = null;
        try{
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("sauceLabsUrl")), capabilities);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }

        return driver;
    }
}
