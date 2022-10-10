package UI.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1StepDefs {
    WebDriver driver;

    @Given("user is on {string} web page")
    public void user_is_on_web_page(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Given("user clicks on Elements button")
    public void user_clicks_on_elements_button() {
        WebElement elements = driver.findElement(By.xpath("(//div[@class=\"avatar mx-auto white\"])[1]"));
        elements.click();
    }

    @Given("user clicks on Text Box button")
    public void user_clicks_on_text_box_button() {
        WebElement textbox = driver.findElement(By.xpath("//span[text()='Text Box']"));
        textbox.click();
    }

    @Then("user should see text {string}")
    public void user_should_see_text(String expectedText) {
        WebElement text = driver.findElement(By.xpath("//label[@id='userName-label']"));
        Assert.assertEquals(expectedText, text.getText());
        driver.close();
    }



}
