package com.emanana2.pestimator;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Service
public class DBConnect {


    Connection conn = null;

    //prepared statement (query) function here
    private void query(Connection connection, String sql){

        try {
            //Connection connection = getConnection();
            Statement com = connection.createStatement();
            System.out.println("query executed");
            com.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get connection => return a connection.
    public Connection excuteQuery(String sql){


        try
        {
            Properties info = new Properties();
            String url;
            url = "jdbc:mysql://localhost:3306/test";
            info.put("user", "root");
            info.put("password", "@Siyamthanda2017");
            conn = DriverManager.getConnection(url, info);
            query(conn, sql);
            return conn;

        }catch(Exception e){
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
