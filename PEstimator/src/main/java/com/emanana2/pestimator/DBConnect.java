package com.emanana2.pestimator;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Service
public class DBConnect {

    public  DBConnect(){

    }

    // get connection => return a connection.
    public Connection getConnection(){

        String url = "jdbc:mysql://localhost:3306/test";
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "@Siyamthanda2017");

        try
        {
            try (Connection conn = DriverManager.getConnection(url, info)) {
                return conn;
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }finally {
            //close connection
           // conn.close();
        }
    }

    //prepared statement (query) function here
    public void query(Connection connection, String queryString){
        try {
            Statement statement = connection.createStatement();
            statement.execute(queryString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
