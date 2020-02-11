package com.inspur.jdbc.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author wang.ning
 * @create 2020-01-30 22:36
 */
public class Test {

    public static void main(String[] args) {

        Long start = System.currentTimeMillis();
        Connection connection = null;

        try{
            //1、加载驱动
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //2、创建连接
            //使用DriverManager获取数据库连接
            connection = DriverManager.getConnection("jdbc:oracle:thin:@10.110.2.61:1521:irms","wx2_simple","wx2_simple");

            //3、创建Statement执行sql
            Statement statement = connection.createStatement();
            String sql = "select username,address,info from sta_user";
            ResultSet resultSet = statement.executeQuery(sql);

            //4、返回数据
            while(resultSet.next()){
                System.out.println(resultSet.getString("username"));
            }

            Long end = System.currentTimeMillis();
            System.out.println("消耗:"+(end-start)+"s");
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
