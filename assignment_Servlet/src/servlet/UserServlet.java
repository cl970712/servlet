package servlet;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;
import util.Base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/loginServlet")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String type = request.getParameter("type");

        if (type.equals("login")) {
            login(request, response);
        } else if (type.equals("reg")) {
            reg(request, response);
        } else if (type.equals("del")) {
            del(request, response);
        } else if (type.equals("getAll")){
            getAll(request, response);
        }

    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userService.del(id);
            request.getSession().setAttribute("msg","删除成功！");
            request.getRequestDispatcher("index/index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("msg","删除失败！");
            request.getRequestDispatcher("index/index.jsp").forward(request, response);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {

        String user = request.getParameter("user");
        String pw = request.getParameter("pw");


        boolean user_login = userService.login(user, pw);

        if (user_login) {
            try {
//                List<User> list = userService.getAll();
//                System.out.println(list);
//                request.getSession().setAttribute("userList", userService.getAll());
                request.getRequestDispatcher("index/index.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void reg(HttpServletRequest request, HttpServletResponse response) {

        String user = request.getParameter("user");
        String pw = request.getParameter("pw");

        System.out.println(user);
        System.out.println(pw);

        String rs = userService.reg(user, pw);

        if (rs.equals(Base.registerSuccess)) {
            try {
                request.getRequestDispatcher("index/login.html").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (rs.equals(Base.registerFalse) && rs.equals(Base.registerRepeated)) {
            try {
                request.getRequestDispatcher("index/register.html").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("userList", userService.getAll());
        try {
            request.getRequestDispatcher("index/index.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
