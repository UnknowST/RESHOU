package cn.dao;

import java.io.Serializable;

/**
 * 用于封装后端返回前端数据对象
 */
public class ResultInfo implements Serializable {
    /**
     * 1=普通用户
     * 2=工人
     * 3=管理员

     */
    public static int num;//标识现在正在使用者的身份
    private int flag;//后端返回结果正常为1，发生异常返回0
    private   Object data;//后端返回结果数据对象
    private String errorMsg;//发生异常的错误消息

    //无参构造方法
    public ResultInfo() {
    }
    public ResultInfo(int flag) {
        this.flag = flag;
    }
    /**
     * 有参构造方法
     * @param flag
     * @param errorMsg
     */
    public ResultInfo(int flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public ResultInfo(int num, int flag, String errorMsg){
        this.num=num;
        this.flag=flag;
        this.errorMsg=errorMsg;
    }
    /**
     * 有参构造方法
     * @param flag
     * @param data
     * @param errorMsg
     */
    public ResultInfo(int flag, int data, String errorMsg, int num) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
        this.num=num;
    }

    public int isFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static Object getNum() {
        return num;
    }

    public static void setNum(int num) {
        cn.dao.ResultInfo.num = num;
    }

}
