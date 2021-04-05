package pers.ifindbook.iFindBook.dao;

import pers.ifindbook.iFindBook.pojo.User;
import pers.ifindbook.iFindBook.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public boolean select(User user) {
        final Connection connection = DBUtils.getConnection();
        final String sql = "select * from user where account = ? and pwd = ?";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getAccount());
            preparedStatement.setString(2, user.getPwd());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtils.closeConnection();
        }
    }

    public boolean insert(User user) {
        final Connection connection = DBUtils.getConnection();
        final String sql = "insert into user(account,nickname,pwd,email) values(?,?,?,?)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getAccount());
            preparedStatement.setString(2, user.getNickname());
            preparedStatement.setString(3, user.getPwd());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.executeUpdate();
            return preparedStatement.getUpdateCount() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtils.closeConnection();
        }
    }
}
