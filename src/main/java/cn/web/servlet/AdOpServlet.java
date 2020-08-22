package cn.web.servlet;

import cn.dao.ResultInfo;
import cn.dao.User;
import cn.service.AdOperationService;
import cn.service.impl.AdOperationServiceimpl;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/adoperation/*")
public class AdOpServlet extends BaseServlet {
    AdOperationService ado=new  AdOperationServiceimpl(); //服务层
    ResultInfo info=new ResultInfo(); //信息记录实体类
    Gson gson=new Gson(); //json
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
    public void DeleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        if(ado.DeleteUser(request.getParameter("snum"))==1){
            info.setFlag(1);
        }else {
            info.setFlag(0);
            info.setErrorMsg("删除失败，请重新删除!");
        }
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }

    /**
     * 插入用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void InsertUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        Map<String, String[]> map = request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if(ado.InsertUser(user)==1){
            info.setFlag(1);
        }else {
            info.setFlag(0);
            info.setErrorMsg("添加失败!");
        }
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }

    /**
     * 根据表单号查找用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void ReaderNum(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        //获取表单号
        String num=request.getParameter("num");
        User user=ado.ReaderNum(num);
       writeValue(user,response);

    }

    /**
     * 管理员更新用户信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void Adupuser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{


        Map<String, String[]> map = request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if(ado.Adupuser(user)==1){
            info.setFlag(1);
        }else {
            info.setFlag(0);
            info.setErrorMsg("修改失败!");
        }
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }


}
