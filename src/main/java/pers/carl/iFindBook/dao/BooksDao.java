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
            return books;
        } finally {
            DBUtils.closeConnection();
        }
    }

    public ArrayList<Book> selectReading(String uid) {
        ArrayList<Book> books = new ArrayList<>();

        final Connection connection = DBUtils.getConnection();
        final String sql = "select books.*\n" +
                "from `books`, `user`, `reading`\n" +
                "where books.id = reading.b_id\n" +
                "and user.id = reading.u_id\n" +
                "and user.id = " + uid;

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

            System.out.println(books);

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

    public ArrayList<Book> selectFav(String uid) {
        ArrayList<Book> books = new ArrayList<>();

        final Connection connection = DBUtils.getConnection();
        final String sql = "select books.*\n" +
                "from `books`, `user`, `fav`\n" +
                "where books.id = fav.b_id\n" +
                "and user.id = fav.u_id\n" +
                "and user.id = " + uid;

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

            System.out.println(books);

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

    public ArrayList<Book> selectRead(String uid) {
        ArrayList<Book> books = new ArrayList<>();

        final Connection connection = DBUtils.getConnection();
        final String sql = "select books.*\n" +
                "from `books`, `user`, `read`\n" +
                "where books.id = read.b_id\n" +
                "and user.id = read.u_id\n" +
                "and user.id = " + uid;

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

            System.out.println(books);

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

    public ArrayList<Book> selectByKeyWord(String keyWord) {
        ArrayList<Book> books = new ArrayList<>();

        final Connection connection = DBUtils.getConnection();
        final String sql = "select * from books where name like ? or author like  ?";

        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, keyWord);
            preparedStatement.setString(2, keyWord);
            ResultSet resultSet = preparedStatement.executeQuery();

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
            return books;
        } finally {
            DBUtils.closeConnection();
        }
    }

    public boolean insertFav(String uid, String bid) {
        final Connection connection = DBUtils.getConnection();
        final String sql = "insert into fav values(?,?)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uid);
            preparedStatement.setString(2, bid);
            preparedStatement.executeUpdate();
            return preparedStatement.getUpdateCount() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtils.closeConnection();
        }
    }

    public boolean insertReading(String uid, String bid) {
        final Connection connection = DBUtils.getConnection();
        final String sql = "insert into reading values(?,?)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uid);
            preparedStatement.setString(2, bid);
            preparedStatement.executeUpdate();
            return preparedStatement.getUpdateCount() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtils.closeConnection();
        }
    }

    public boolean deleteReading(String uid, String bid) {
        final Connection connection = DBUtils.getConnection();
        final String sql = "delete from reading where u_id = " + uid + " and b_id = " + bid + ";";
        try {
            final Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return statement.getUpdateCount() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtils.closeConnection();
        }
    }

    public boolean deleteRead(String uid, String bid) {
        final Connection connection = DBUtils.getConnection();
        final String sql = "delete from `read` where u_id = " + uid + " and b_id = " + bid + ";";
        try {
            final Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            return statement.getUpdateCount() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtils.closeConnection();
        }
    }

    public boolean insertRead(String uid, String bid) {
//        final Connection connection = DBUtils.getConnection();
//        final String sql = "insert into `read` values(" + uid + "," + bid + ")";
//        try {
//            final Statement statement = connection.createStatement();
//            statement.executeUpdate(sql);
//            return statement.getUpdateCount() != 0;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            DBUtils.closeConnection();
//        }
        final Connection connection = DBUtils.getConnection();
        final String sql = "insert into `read` values(?,?)";
        try {
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, uid);
            preparedStatement.setString(2, bid);
            preparedStatement.executeUpdate();
            return preparedStatement.getUpdateCount() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtils.closeConnection();
        }
    }

    public ArrayList<Book> selectRecmd() {
        ArrayList<Book> books = new ArrayList<>();

        final Connection connection = DBUtils.getConnection();
        final String sql = "select `books`.* from `books`,`recmd` where `recmd`.`b_id` = `books`.`id`";

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
            return books;
        } finally {
            DBUtils.closeConnection();
        }
    }
}
