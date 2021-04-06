package pers.carl.iFindBook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.carl.iFindBook.dao.UserDao;
import pers.carl.iFindBook.pojo.User;
import pers.carl.iFindBook.response.ResponseBody;

import java.io.IOException;

@WebServlet("/sign/in")
public class SignInServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("sign in called.");

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");

        System.out.println(account + "---" +pwd);

        UserDao userDao = new UserDao();
        User user = new User(-1, account,null, pwd, null);
        ObjectMapper mapper = new ObjectMapper();
        ResponseBody responseBody = new ResponseBody();

        if (userDao.select(user)) {
            responseBody.setResponseCode(200);
            responseBody.setResponseData("success");
        } else {
            responseBody.setResponseCode(404);
            responseBody.setResponseData("fail");
        }
        mapper.writeValue(resp.getWriter(), responseBody);

    }
}
