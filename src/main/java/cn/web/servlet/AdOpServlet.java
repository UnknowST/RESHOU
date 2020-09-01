package cn.web.servlet;

import cn.dao.Bill;
import cn.dao.ResultInfo;
import cn.dao.User;
import cn.dao.Worker;
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
import java.util.ArrayList;
import java.util.HashMap;
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



    /**
     * 查看所有的维修记录和回复消息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void Lookinfor_all(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        Map<String,Object> map=new HashMap<>();
        map=ado.lookmes();
        writeValue(map,response);

    }

    /**
     * 管理员删除指定的infor和replay记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void DeleteInfor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        String num=request.getParameter("num");
        if(ado.DeletrInfor(num)==1){
            info.setFlag(1);
        }else {
            info.setFlag(0);
            info.setErrorMsg("删除失败!");
        }
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }

    /**
     * 读出账单记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void ReaderBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        List<Bill> list=ado.ReaderBill();
        writeValue(list,response);
    }

    /**
     * 读出指定单号的账单记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void ReaderBillnum(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
       Bill bill=ado.ReaderBillnum(request.getParameter("num"));
       writeValue(bill,response);
    }

    /**
     * 管理员更新bill表
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void UpdateBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        //获取数据
        Map<String, String[]> map = request.getParameterMap();
        Bill bill=new Bill();
        try {
            BeanUtils.populate(bill, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if(ado.UpdateBill(bill)==1){
            info.setFlag(1);
        }else {
            info.setFlag(0);
            info.setErrorMsg("修改失败请重新修改!");
        }

        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }

    /**
     * 管理员删除账单记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void DeleteBill(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        //获取数据

        if(ado.DeleteBill(request.getParameter("num"))==1){
            info.setFlag(1);
        }else {
            info.setFlag(0);
            info.setErrorMsg("删除失败!");
        }

        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }

    /**
     * 管理员查询当前记录的最后一个id
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void SelectWorkerId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        //获取数据
        String id=ado.SelectWorkerId();
        Map<String, Integer> map=new HashMap();
        int newid =Integer.parseInt(id);
        newid+=1;
        map.put("id",newid);
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(map));

    }

    /**
     * 读出worker表中的记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void ReaderWorker(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        List<Worker> list=ado.ReaderWork();
        writeValue(list,response);

    }

    /**
     * 插入工人记录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void InsertWorker(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException{
        //获取数据
        Map<String, String[]> map = request.getParameterMap();
       Worker worker=new Worker();
        try {
            BeanUtils.populate(worker, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        if(ado.InsertWorker(worker)==1){
            info.setFlag(1);
        }else {
            info.setFlag(0);
            info.setErrorMsg("添加失败!");
        }

        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }

}

