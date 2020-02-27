package com.periodestimator.PEstimator;


import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Properties;

@Service
public class DBConnect {


    Connection conn = null;

    // CRD queries
    private void query(Connection connection, String sql){

        try {
            //Connection connection = getConnection();
            //Statement com = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // get connection => return a connection.
    public Connection excuteQueryC(String sql){

        try
        {
            Properties info = new Properties();
            String url;
            url = "jdbc:mysql://localhost:3306/pestimator";
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