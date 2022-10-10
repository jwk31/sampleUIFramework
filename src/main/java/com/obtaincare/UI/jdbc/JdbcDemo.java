package com.obtaincare.UI.jdbc;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Set;

public class JdbcDemo {

    @Test
    public void testAssert() {
        ResultSet resultSet = JdbcDriver.loadJdbcDriver("select A.firstName as firstName, A.lastName as lastName from employees A, employees B\n" +
                "where B.firstName = 'Mary' and B.lastName = 'Patterson' and B.reportsTo = A.employeeNumber;");
        try{
            while(resultSet.next()){
                Assert.assertEquals("Diane Murphy",resultSet.getString(1) + " " + resultSet.getString(2));
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/realparsmodel";

            String userName = "root";
            String password = "Samsung103110!";

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url,userName,password);

            Statement statement = connection.createStatement();
            String query = "select A.firstName as firstName, A.lastName as lastName from employees A, employees B\n" +
                    "where B.firstName = 'Mary' and B.lastName = 'Patterson' and B.reportsTo = A.employeeNumber;";

            ResultSet resultSet = statement.executeQuery(query);
          //  Set<String> set = (Set<String>) resultSet;

          //  System.out.println(set);
            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }

            connection.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
