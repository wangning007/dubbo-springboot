package com.inspur.jdbc.dao;

import com.inspur.api.dao.IUserDao;
import com.inspur.domain.model.User;
import com.inspur.jdbc.common.ConnectionFactory;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wang.ning
 * @create 2020-02-02 11:27
 */
public class UserDao implements IUserDao {

    private static BasicDataSource ds = null;

    static {
        ds = new BasicDataSource();
        ds.setDriverClassName(ConnectionFactory.driver);
        ds.setUrl(ConnectionFactory.url);
        ds.setUsername(ConnectionFactory.username);
        ds.setPassword(ConnectionFactory.password);

        ds.setInitialSize(10);
        ds.setMaxActive(20);
        ds.setMinIdle(2);
    }



    @Override
    public List<User> findAllUserName() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List list = new ArrayList();
        String sql = "select username from sta_user";
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String username = resultSet.getString("username");
                User user = new User();
                user.setUsername(username);
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.releaseAll(resultSet,preparedStatement,connection);
        }
        return list;
    }

    @Override
    public List<User> findAllUserNameByDbCP() {
        Connection connection = null;
        List list = new ArrayList();
        try {
            connection = ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select username from sta_user");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                String username = resultSet.getString("username");
                User user = new User();
                user.setUsername(username);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.releaseAll(null,null,connection);
        }
        return list;
    }
}
