package UI.stepDefs;

import com.obtaincare.UI.dataProviders.ConfigReader;
import com.obtaincare.UI.pageObject.LoginPage;
import com.obtaincare.UI.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

public class LoginPageSteps extends BaseUITest{


    @Given("user is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("environment"));
    }

    @When("user type {string} in username input field")
    public void user_type_in_username_input_field(String userNameOrEmail) {
       loginPage.inputUserNameOrEmail(userNameOrEmail);
    }
    @When("user type {string} in password input field")
    public void user_type_in_password_input_field(String password) {
        loginPage.inputPassword(password);
    }
    @When("user click on Login button")
    public void user_click_on_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("user should successfully land to Home page")
    public void user_should_successfully_land_to_home_page() {
        String expectedText = "Home";
        assertClass.assertTextWithGetText(expectedText,homePage.textOfHomePage);
    }
}
