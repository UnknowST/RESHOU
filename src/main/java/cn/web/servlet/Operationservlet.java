package cn.web.servlet;

import cn.dao.Infor;
import cn.dao.ResultInfo;
import cn.dao.User;
import cn.service.OperationService;
import cn.service.impl.OperationServiceimpl;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@WebServlet("/operation/*")
public class Operationservlet extends BaseServlet{

    ResultInfo info=new ResultInfo();
    Gson gson=new Gson();
    //调用方法
    OperationService ops=new OperationServiceimpl();
    public void Register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //1.生成用户对象
        User user =new User();

        //3.数据流中获取对象
        Gson gson=new Gson();//阿里巴巴的实体类转化为json数据工具
        String check = request.getParameter("check");
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            //登陆失败
            info.setFlag(0);
            info.setErrorMsg("验证码错误");
        }else{
            Map<String, String[]> map = request.getParameterMap();
            //封装对象
            try {
                BeanUtils.populate(user, map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            if(ops.Register(user)==1) {
                info.setFlag(1);
            }
            else {
                info.setFlag(0);
                info.setErrorMsg("注册失败！");
            }

        }
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));
    }


    public void Apply(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Infor inf=new Infor();

        List<String> plist=new ArrayList<>();
        String paths;  //最终保存路径
        String filename = null;
        // 设置上传图片的保存路径
        String savePath = this.getServletContext().getRealPath("/images");
        File file = new File(savePath);
        // 判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            // 创建目录
            file.mkdir();
        }
        //1,
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        // 3、判断提交上来的数据是否是上传表单的数据
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 按照传统方式获取数据
            return;
        }
        try {
            List<FileItem> list = upload.parseRequest(request);
            System.out.println("路径"+list.toString());// 文件的路径 以及保存的路径
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                FileItem item = (FileItem)iterator.next();
                if (item.isFormField()) {                               // 判断数据流是不是文件
                    String value=item.getString("utf-8");           //把不是文件的数据全部加入plist
                    plist.add(value);
                    continue;
                }else{
                    InputStream strem=item.getInputStream();
                    filename = item.getName();
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    System.out.print(filename);
                    if (filename.substring(filename.lastIndexOf(".") + 1).equals("png")//判断是不是图片
                            || filename.substring(filename.lastIndexOf(".") + 1).equals("jpg")
                            || filename.substring(filename.lastIndexOf(".") + 1).equals("jpeg")) {
                        InputStream in = item.getInputStream();//获得上传的输入流
                        FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);// 指定web-inf目錄下的images文件
                        request.setAttribute("path",  "images"+"\\" + filename);
                        //System.out.println(savePath+">>>>>");  //输出文件保存路径
                        paths="images"+"\\" + filename;
                        inf.setImagepath(paths);
                        int len = 0;
                        byte buffer[] = new byte[1024];
                        while ((len = in.read(buffer)) > 0)// 每次读取
                        {
                            out.write(buffer, 0, len);
                        }
                        in.close();      //关闭流
                        out.close();
                        item.delete();


                        inf.setPlace(plist.get(0));   //将其他数据读出
                        inf.setEquip(plist.get(1));
                        inf.setDetail(plist.get(2));
                        inf.setState("待维修");
                        System.out.println("test"+plist.get(0)+" "+plist.get(1));

                    }
                }}
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }
    public void Seeinfor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
            Userinfor use1=new Userinfor();

            List<Infor> list=ops.Seeinfor(use1.findid(request,response));
            writeValue(list,response);
    }

    public void infor_details(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String num=request.getParameter("re");
        System.out.println(num);
        Map<String,Object> map=new HashMap<>();
        map=ops.lookmes(num);

        writeValue(map,response);
    }
    public void Fenshu(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
          String num=request.getParameter("num");
          String fenshu=request.getParameter("fenshu");
          int n=ops.Pinfen(fenshu,num);
        ResultInfo info=new ResultInfo();
          if(n==1) {
              info.setFlag(1);
          }else
          {
              info.setFlag(0);
              info.setErrorMsg("出现未知错误,请重新评分。");
          }
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }
    public void DeleteInfor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String num=request.getParameter("num");

        int n=ops.DeleteInfor(num);
        ResultInfo info=new ResultInfo();
        if(n==1) {
            info.setFlag(1);
        }else
        {
            info.setFlag(0);
            info.setErrorMsg("出现未知错误,删除失败。");
        }
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }
    public void modif_user(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String username=request.getParameter("username");
        String mail=request.getParameter("mail");
        String phone=request.getParameter("phone");
        String check = request.getParameter("check");   //获取验证码
        //获取用户id;
        Userinfor infor=new Userinfor();
        String id=infor.findid(request,response);
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            //登陆失败
            info.setFlag(0);
            info.setErrorMsg("验证码错误");
        }else{
            if(ops.modifUser(id,username,mail,phone)==1){
                info.setFlag(1);
            }
            else {
                info.setFlag(0);
                info.setErrorMsg("出现未知错误,信息修改失败!");
            }
        }
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }

    public void modifpass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String password=request.getParameter("password");
        String password1=request.getParameter("password1");

        String check = request.getParameter("check");   //获取验证码
        //获取用户id;
        Userinfor infor=new Userinfor();
        String id=infor.findid(request,response);
        //从sesion中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//为了保证验证码只能使用一次
        //比较
        if(checkcode_server == null || !checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            //登陆失败
            info.setFlag(0);
            info.setErrorMsg("验证码错误");
        }else{
            if(ops.modifuserpass(id,password,password1)==1){
                info.setFlag(1);
            }
            else {
                info.setFlag(0);
                info.setErrorMsg("修改失败原密码错误");
            }
        }
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));

    }
    public void Lookinfor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        Userinfor infor=new Userinfor();
        String id=infor.findid(request,response);
        List<Infor> list=ops.Lookinfor(id);
        writeValue(list,response);

    }

    public void Reinfor(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        String num=request.getParameter("num");
        String workerid=request.getParameter("workerid");
        String userid=request.getParameter("userid");
        String status=request.getParameter("statu");
         if(ops.Reinfor(num,userid,workerid,status)==1){
             info.setFlag(1);
         }
         else {
             info.setFlag(0);
             info.setErrorMsg("回复失败！");
         }
        //json格式返回数据
        response.setContentType("application/x-json;charset=utf-8");
        response.getWriter().write(gson.toJson(info));



    }



}
