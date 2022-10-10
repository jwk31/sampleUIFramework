package UI.stepDefs.dbSteps;

import DB.beans.EmployeeBean;
import DB.dbUtils.DBConnection;
import com.obtaincare.UI.dataProviders.ConfigReader;
import com.obtaincare.UI.pojo.LoginPojo;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AddAndDeleteEmployeeViaDBSteps extends BaseDBTest {

    SoftAssertions softAssertions = new SoftAssertions();

    @DataTableType
    public EmployeeBean employeeBeanTransformer(Map<String, String> row) {
        return new EmployeeBean(
                row.get("employeeNumber"),
                row.get("lastName"),
                row.get("firstName"),
                row.get("extension"),
                row.get("email"),
                row.get("officeCode"),
                row.get("reportsTo"),
                row.get("jobTitle")
        );
    }

    @Given("connect to Database")
    public void connect_to_database() throws SQLException {
        DBConnection.open(ConfigReader.getProperty("dbname"));
        System.out.println("DB is created");
    }

    @Given("create new employee with following credentials:")
    public void create_new_employee_with_following_credentials(List<EmployeeBean> employeeBeanList) throws SQLException {
        employeeBean.createEmployeeWithAllColumns(employeeBeanList.get(0).getEmployeeNumber(), employeeBeanList.get(0).getLastName(),
                employeeBeanList.get(0).getFirstName(), employeeBeanList.get(0).getExtension(), employeeBeanList.get(0).getEmail(),
                employeeBeanList.get(0).getOfficeCode(), employeeBeanList.get(0).getReportsTo(), employeeBeanList.get(0).getJobTitle());
        System.out.println("new employee is created");
    }

    @Then("check this employee in Database")
    public void check_this_employee_in_database(List<EmployeeBean> employeeBeanList) throws SQLException {
        EmployeeBean eB = employeeBean.getBy("employeeNumber", employeeBeanList.get(0).getEmployeeNumber()).get(0);
        Assertions.assertThat(eB.getLastName()).isEqualTo(employeeBeanList.get(0).getLastName());
        Assertions.assertThat(eB.getFirstName()).isEqualTo(employeeBeanList.get(0).getFirstName());
        Assertions.assertThat(eB.getExtension()).isEqualTo(employeeBeanList.get(0).getExtension());
        Assertions.assertThat(eB.getEmail()).isEqualTo(employeeBeanList.get(0).getEmail());
        Assertions.assertThat(eB.getOfficeCode()).isEqualTo(employeeBeanList.get(0).getOfficeCode());
        Assertions.assertThat(eB.getReportsTo()).isEqualTo(employeeBeanList.get(0).getReportsTo());
        Assertions.assertThat(eB.getJobTitle()).isEqualTo(employeeBeanList.get(0).getJobTitle());

        System.out.println("checked");

    }

    @When("delete employee by {string} which is {string}")
    public void delete_employee_by_which_is(String column, String value) throws SQLException {
        employeeBean.deleteEmployeeByValue(column, value);
        System.out.println("employee is deleted");
    }

    @Then("check it in Database by {string} which is {string}")
    public void check_it_in_database_by_which_is(String column, String value) throws SQLException {
        List<EmployeeBean> list = employeeBean.getBy(column, value);
        Assertions.assertThat(list.size()).isEqualTo(0);
        System.out.println("check2");
    }

    @Test
    public void delete() throws SQLException {
        DBConnection.open(ConfigReader.getProperty("dbname"));
        employeeBean.deleteEmployeeByValue("employeeNumber", "2000");
    }
}
