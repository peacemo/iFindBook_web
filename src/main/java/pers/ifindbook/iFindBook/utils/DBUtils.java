package pers.ifindbook.iFindBook.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    private static Connection connection = null;

    /**
     * get mysql connection util
     * @return the connection to mysql: Connection
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            final String url = "jdbc:mysql://127.0.0.1:3306/ifindbook";
            final String usrName = "root";
            final String pwd = "123";
            connection = DriverManager.getConnection(url, usrName, pwd);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }

    /**
     * close the connection to mysql
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
