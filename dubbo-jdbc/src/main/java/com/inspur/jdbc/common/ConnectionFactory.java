package com.inspur.jdbc.common;

import lombok.Data;

import java.sql.*;
import java.util.Properties;

/**
 * @author wang.ning
 * @create 2020-01-31 21:46
 */
@Data
public class ConnectionFactory {

    public static String driver = null;
    public static String url = null;
    public static String username = null;
    public static String password = null;
    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    static {
        try{
            Properties properties = new Properties();
            properties.load(ConnectionFactory.class.getResourceAsStream("/db.ini"));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放所有资源
     */
    public static void releaseAll(ResultSet resultSet,PreparedStatement preparedStatement,Connection connection){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
