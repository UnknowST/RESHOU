package cn.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

//import java.util.Date;
import java.sql.Date;
public class User {
    /**
     * 用户信息表
     * 对应信息为序号，账号，学院，用户名，密码，姓名，电话，性别，邮箱，注册时间
     */
    String snum;
    String id,collage,username,password,name,phone,gender,mail;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date createdate;
    /**
     * 无参构造函数
     */
    public User(){}

    /**
     * 有参构造函数
     * @param snum
     * @param id
     * @param collage
     * @param username
     * @param password
     * @param name
     * @param phone
     * @param gender
     * @param mail
     * @param createdate
     */
    public User(String snum, String id, String collage, String username, String password, String name, String phone, String gender, String mail, Date createdate) {
        this.snum = snum;
        this.id = id;
        this.collage = collage;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.mail = mail;
        this.createdate = createdate;
    }

    /**
     * 不带时间的有参构造函数
     * @param snum
     * @param id
     * @param collage
     * @param username
     * @param password
     * @param name
     * @param phone
     * @param gender
     * @param mail
     */
    public User(String snum, String id, String collage, String username, String password, String name, String phone, String gender, String mail) {
        this.snum = snum;
        this.id = id;
        this.collage = collage;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.mail = mail;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "snum='" + snum + '\'' +
                ", id='" + id + '\'' +
                ", collage='" + collage + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", mail='" + mail + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}
