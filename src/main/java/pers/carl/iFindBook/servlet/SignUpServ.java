package pers.carl.iFindBook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pers.carl.iFindBook.dao.UserDao;
import pers.carl.iFindBook.pojo.User;
import pers.carl.iFindBook.response.ResponseBody;

import java.io.IOException;

@WebServlet("/sign/up")
public class SignUpServ extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("sign up called.");

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String account = req.getParameter("account");
        String nickname = req.getParameter("nickname");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");

        System.out.println("{" + account +", " + nickname +", "+ pwd +", "+ email + "}");

        UserDao userDao = new UserDao();
        User user = new User(-1, account, nickname, pwd, email);

        ResponseBody responseBody = new ResponseBody();
        ObjectMapper mapper = new ObjectMapper();

        if (userDao.insert(user)) {
            responseBody.setResponseCode(200);
            responseBody.setResponseData("success");
        } else {
            responseBody.setResponseCode(500);
            responseBody.setResponseData("failed");
        }
        mapper.writeValue(resp.getWriter(), responseBody);
    }
}
