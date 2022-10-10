package UI.demoqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class testWindowsHandler {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");
    }

    @AfterEach
    public void closeBrowser(){

        // driver.close();
       //  driver.quit();
    }

    @Test
    public void testNewTab(){

        String currentPage = driver.getWindowHandle();

        for (int i = 0; i < 5; i++) {
            WebElement newTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
            newTabButton.click();
            driver.switchTo().window(currentPage);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        List<String> pages = new LinkedList<>(driver.getWindowHandles());

        driver.switchTo().window(pages.get(2));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
