package pers.ifindbook.iFindBook.dao;

import pers.ifindbook.iFindBook.pojo.Book;
import pers.ifindbook.iFindBook.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class BooksDao {
    public ArrayList<Book> selectAll() {
        ArrayList<Book> books = null;

        final Connection connection = DBUtils.getConnection();
        final String sql = "select * from books";

        try {
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                books.add(new Book(
                                    resultSet.getString("name"),
                                    resultSet.getString("author"),
                                    resultSet.getString("img_url"),
                                    resultSet.getString("short_desc"),
                                    resultSet.getString("long_desc")
                                )
                            );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnection();
        }

        return books;
    }

}
