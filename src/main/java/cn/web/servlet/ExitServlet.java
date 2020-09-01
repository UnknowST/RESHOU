package cn.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exitServlet")
public class  ExitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.销毁session
        request.getSession().invalidate();
        //2.跳转登录页面
        System.out.println("退出方法被执行了");
        response.sendRedirect(request.getContextPath()+"/Login.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.销毁session
        request.getSession().invalidate();
        //2.跳转登录页面
        System.out.println("退出方法被执行了");
        response.sendRedirect(request.getContextPath()+"/Login.html");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁session
        req.getSession().invalidate();
        //2.跳转登录页面
        System.out.println("退出方法被执行了...service");
        resp.sendRedirect(req.getContextPath()+"/Login.html");
    }
}
