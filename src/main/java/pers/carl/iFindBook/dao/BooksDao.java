package pers.carl.iFindBook.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pers.carl.iFindBook.pojo.Book;
import pers.carl.iFindBook.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;

public class BooksDao {
    public ArrayList<Book> selectAll(String table) {
        ArrayList<Book> books = new ArrayList<>();

        final Connection connection = DBUtils.getConnection();
        final String sql = "select * from " + table;

        try {
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String imgUrl = resultSet.getString("img_url");
                String shortDesc = resultSet.getString("short_desc");
                String longDesc = resultSet.getString("long_desc");
                Book book = new Book(id, name, author, imgUrl, shortDesc, longDesc);
                books.add(book);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(books);
            System.out.println(s);

            return books;

        } catch (SQLException | JsonProcessingException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtils.closeConnection();
        }
    }

}
