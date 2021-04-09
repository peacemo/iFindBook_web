package pers.carl.iFindBook.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.carl.iFindBook.dao.BooksDao;

import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().print("Hello, Java Web");

        /**
         * this is the Test Unit, put code here, and visit /test
         */
        BooksDao booksDao = new BooksDao();
//        booksDao.selectReading("1");
        booksDao.insertFav("2","1");
    }
}