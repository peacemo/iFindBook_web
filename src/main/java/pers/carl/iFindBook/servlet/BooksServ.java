package pers.carl.iFindBook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import pers.carl.iFindBook.dao.BooksDao;
import pers.carl.iFindBook.pojo.Book;
import pers.carl.iFindBook.response.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/books/all")
public class BooksServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("books called.");

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

//        String account = req.getParameter("account");
//        String pwd = req.getParameter("pwd");
        String table = req.getParameter("table");
        System.out.println(table);

//        System.out.println(account + "---" +pwd);
//
        BooksDao booksDao = new BooksDao();
//        User user = new User(-1, account,null, pwd, null);
        ObjectMapper mapper = new ObjectMapper();
        ResponseBody responseBody = new ResponseBody();
        ArrayList<Book> books = booksDao.selectAll(table);

        if (books != null) {
            responseBody.setResponseCode(200);
            responseBody.setResponseData("success");
//            String res = mapper.writeValueAsString(books);
            mapper.writeValue(resp.getWriter(), books);
        } else {
            responseBody.setResponseCode(404);
            responseBody.setResponseData("fail");
            mapper.writeValue(resp.getWriter(), new ArrayList<Book>());
        }
//        mapper.writeValue(resp.getWriter(), responseBody);
//        String res = mapper.writeValueAsString(books);
//        System.out.println(res);
    }
}
