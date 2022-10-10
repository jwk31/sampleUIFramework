package com.obtaincare.UI.jdbc;

import com.obtaincare.UI.dataProviders.ConfigReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class JdbcDriver {
    private static String driver = "com.mysql.jdbc.Driver";

    public static ResultSet loadJdbcDriver(String query) {

        ResultSet resultSet = null;

        try {
            String url = ConfigReader.getProperty("url");

            String userName = ConfigReader.getProperty("userName");
            String password = ConfigReader.getProperty("password");

            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url, userName, password);

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(query);

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();


        }
        return resultSet;
    }
}
