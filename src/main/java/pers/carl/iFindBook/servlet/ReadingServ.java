package pers.carl.iFindBook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.carl.iFindBook.dao.BooksDao;
import pers.carl.iFindBook.pojo.Book;
import pers.carl.iFindBook.response.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/books/reading")
public class ReadingServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("reading called.");

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

//        String account = req.getParameter("account");
        String uid = req.getParameter("uid");

        BooksDao booksDao = new BooksDao();
        ObjectMapper mapper = new ObjectMapper();
        ResponseBody responseBody = new ResponseBody();
        ArrayList<Book> books = booksDao.selectReading(uid);

        if (books != null) {
            responseBody.setResponseCode(200);
            responseBody.setResponseData("success");
            mapper.writeValue(resp.getWriter(), books);
        } else {
            responseBody.setResponseCode(404);
            responseBody.setResponseData("fail");
            mapper.writeValue(resp.getWriter(), new ArrayList<Book>());
        }
    }
}
