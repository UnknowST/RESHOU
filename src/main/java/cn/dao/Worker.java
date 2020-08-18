package cn.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Date;
public class Worker {
    /**
     * 工人实体类对象
     * 对应信息为
     * 序号，账号，密码，姓名，电话，性别，邮箱，职位，工作状态，平均评分，时间
     */
    String snum,id,password,name,phone,gender,mail,position,workstate,sum_eval;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date createdate;
    /**
     * 无参构造函数
     */
    public Worker(){}
    /**
     * 有参构造函数
     * @param snum
     * @param id
     * @param password
     * @param name
     * @param phone
     * @param gender
     * @param mail
     * @param position
     * @param workstate
     * @param sum_eval
     * @param createdate
     */
    public Worker(String snum, String id, String password, String name, String phone, String gender, String mail, String position, String workstate, String sum_eval, Date createdate) {
        this.snum = snum;
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.mail = mail;
        this.position = position;
        this.workstate = workstate;
        this.sum_eval = sum_eval;
        this.createdate = createdate;
    }
    /**
     * 不带时间的有参构造函数
     * @param snum
     * @param id
     * @param password
     * @param name
     * @param phone
     * @param gender
     * @param mail
     * @param position
     * @param workstate
     * @param sum_eval
     */
    public Worker(String snum, String id, String password, String name, String phone, String gender, String mail, String position, String workstate, String sum_eval) {
        this.snum = snum;
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.mail = mail;
        this.position = position;
        this.workstate = workstate;
        this.sum_eval = sum_eval;
    }

    public String getsnum() {
        return snum;
    }

    public void setsnum(String snum) {
        this.snum = snum;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkstate() {
        return workstate;
    }

    public void setWorkstate(String workstate) {
        this.workstate = workstate;
    }

    public String getSum_eval() {
        return sum_eval;
    }

    public void setSum_eval(String sum_eval) {
        this.sum_eval = sum_eval;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
