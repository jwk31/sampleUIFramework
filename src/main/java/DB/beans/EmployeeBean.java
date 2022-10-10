package DB.beans;

import DB.dbUtils.DBConnection;
import lombok.Data;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeBean {

    private String employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private String reportsTo;
    private String jobTitle;

    public EmployeeBean() {
    }

    public EmployeeBean(String employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, String reportsTo, String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    public EmployeeBean(ResultSet rs) throws SQLException {
        new BeanProcessor().populateBean(rs, this);
    }


    public List<EmployeeBean> getAll() throws SQLException {
        String query = "SELECT * FROM employees;";
        ResultSet resultSet = DBConnection.querySelect(query);
        return new BeanProcessor().toBeanList(resultSet, EmployeeBean.class);
    }

    public List<EmployeeBean> getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM employees WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.querySelect(query, value);
        List<EmployeeBean> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new BeanProcessor().toBean(resultSet, EmployeeBean.class));
        }
        return list;

//        return new BeanProcessor().toBeanList(resultSet, EmployeeBean.class);

    }

    public void createEmployeeWithAllColumns(String employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, String reportsTo, String jobTitle) throws SQLException {
        String query = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?);";
        DBConnection.queryInsert(query,employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle);
    }

    public void deleteEmployeeByValue(String column, String value) throws SQLException {
        String query = "DELETE FROM employees WHERE " + column + " = ?;";
        DBConnection.queryInsert(query,value);
    }
}
