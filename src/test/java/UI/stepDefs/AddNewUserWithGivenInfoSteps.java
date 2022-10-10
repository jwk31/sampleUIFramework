package UI.stepDefs;

import com.obtaincare.UI.dataProviders.ConfigReader;
import com.obtaincare.UI.pojo.LoginPojo;
import com.obtaincare.UI.pojo.UserPojo;
import com.obtaincare.UI.utils.Driver;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddNewUserWithGivenInfoSteps extends BaseUITest {

    Map<String, String> userInfoList = new HashMap<>();


    @DataTableType
    public LoginPojo loginEntryTransformer(Map<String, String> row) {
        return new LoginPojo(
                row.get("userNameOrEmail"),
                row.get("password")
        );
    }

    @DataTableType
    public UserPojo userEntryTransformer(Map<String, String> row) {
        return new UserPojo(
                row.get("firstName"),
                row.get("lastName"),
                row.get("emailAddress"),
                row.get("userName"),
                row.get("password"),
                row.get("bio"),
                row.get("userType"),
                row.get("timeZone"),
                row.get("language")

        );
    }

    public enum USERDETAILS {
        firstName,
        lastName,
        email,
        userName,
        password,
        bio,
        userType,
        timeZone,
        language
    }

    @Given("login with following credentials as admin:")
    public void login_with_following_credentials_as_admin(List<LoginPojo> loginPojoList) {
        Driver.getDriver().get(ConfigReader.getProperty("environment"));
        loginPage.loginToSystem(loginPojoList.get(0).getUserNameOrEmail(), loginPojoList.get(0).getPassword());
    }

    @When("admin clicks on Add user button")
    public void admin_clicks_on_add_user_button() {
        homePage.clickAddUserButton();
    }

    @Then("admin should see Add user page")
    public void admin_should_see_add_user_page() {
        String expectedText = "Home / Users / Add user";
        assertClass.assertTextWithGetText(expectedText, addUserPage.textOfAddUserPage);
    }

    @When("admin fills input fields with following new user info:")
    public void admin_fills_input_fields_with_following_new_user_info(List<UserPojo> userPojoList) {
        userInfoList.put(USERDETAILS.firstName.toString(), userPojoList.get(0).getFirstName());
        userInfoList.put(USERDETAILS.lastName.toString(), userPojoList.get(0).getLastName());
        userInfoList.put(USERDETAILS.email.toString(), userPojoList.get(0).getEmailAddress());
        userInfoList.put(USERDETAILS.userName.toString(), userPojoList.get(0).getUserName());
        userInfoList.put(USERDETAILS.password.toString(), userPojoList.get(0).getPassword());
        userInfoList.put(USERDETAILS.bio.toString(), userPojoList.get(0).getBio());
        userInfoList.put(USERDETAILS.userType.toString(), userPojoList.get(0).getUserType());
        userInfoList.put(USERDETAILS.timeZone.toString(), userPojoList.get(0).getTimeZone());
        userInfoList.put(USERDETAILS.language.toString(), userPojoList.get(0).getLanguage());

        addUserPage.inputAllUserInfo(userPojoList.get(0).getFirstName(), userPojoList.get(0).getLastName(),
                userPojoList.get(0).getEmailAddress(), userPojoList.get(0).getUserName(),
                userPojoList.get(0).getPassword(), userPojoList.get(0).getBio(),
                userPojoList.get(0).getUserType(), userPojoList.get(0).getTimeZone(),
                userPojoList.get(0).getLanguage());

    }

    @Then("user should see user information in new Page")
    public void user_should_see_user_information_in_new_page() {
        userInfoPage.clickInfoButton();
        assertClass.assertTextWithValueByAttribute(userInfoList.get(USERDETAILS.firstName.toString()), userInfoPage.firstNameInput);
        assertClass.assertTextWithValueByAttribute(userInfoList.get(USERDETAILS.lastName.toString()), userInfoPage.lastNameInput);
        assertClass.assertTextWithValueByAttribute(userInfoList.get(USERDETAILS.email.toString()), userInfoPage.emailAddressInput);
        assertClass.assertTextWithValueByAttribute(userInfoList.get(USERDETAILS.userName.toString()), userInfoPage.usernameInput);
        assertClass.assertTextWithGetText(userInfoList.get(USERDETAILS.bio.toString()), userInfoPage.bioInput);
        assertClass.assertTextWithGetTextFromSelect(userInfoList.get(USERDETAILS.userType.toString()), userInfoPage.userTypeSelect, 3);
        assertClass.assertTextWithGetTextFromSelect(userInfoList.get(USERDETAILS.language.toString()), userInfoPage.languageSelect, 0);
    }

}
