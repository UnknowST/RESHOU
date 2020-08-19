package cn.web.servlet;

import cn.dao.ResultInfo;
import cn.dao.User;
import cn.service.AdOperationService;
import cn.service.impl.AdOperationServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/adoperation/*")
public class AdOpServlet extends BaseServlet {
    AdOperationService ado=new  AdOperationServiceimpl(); //服务层
    ResultInfo info=new ResultInfo(); //信息记录实体类
    /**
     * 读出用户信息记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void ReaderUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        List<User> list=ado.ReaderUser();
        writeValue(list,response);  //json数据

    }

}
