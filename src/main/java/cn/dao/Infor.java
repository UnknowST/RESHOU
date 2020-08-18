package cn.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Date;
public class Infor {
    /**
     * 对应信息申报表
     * 序号，申报人账号，位置，设备，详细信息，图片路径，评分，维修师傅账号，维修状态
     */
    String cid,userid,place,equip,detail,imagepath,evaluate,workerid,state;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date createdate;
    /**
     * 无参构造函数
     */
    public Infor(){}
    /**
     * 有参构造函数
     */
    /**
     * @param cid,
     * @param userid
     * @param place
     * @param equip
     * @param detail
     * @param imagepath
     * @param evaluate
     * @param workerid
     * @param state
     * @param createdate
     */
    public Infor(String cid, String userid, String place, String equip, String detail, String imagepath, String evaluate, String workerid, String state, Date createdate) {
        this.cid = cid;
        this.userid = userid;
        this.place = place;
        this.equip = equip;
        this.detail = detail;
        this.imagepath = imagepath;
        this.evaluate = evaluate;
        this.workerid = workerid;
        this.state = state;
        this.createdate = createdate;
    }
    /**
     * 不带时间的有参构造函数
     *
     */
    /**
     * @param cid,
     * @param userid
     * @param place
     * @param equip
     * @param detail
     * @param imagepath
     * @param evaluate
     * @param workerid
     * @param state

     */
    public Infor(String cid, String userid, String place, String equip, String detail, String imagepath, String evaluate, String workerid, String state) {
        this.cid = cid;
        this.userid = userid;
        this.place = place;
        this.equip = equip;
        this.detail = detail;
        this.imagepath = imagepath;
        this.evaluate = evaluate;
        this.workerid = workerid;
        this.state = state;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getworkerid() {
        return workerid;
    }

    public void setworkerid(String workerid) {
        this.workerid = workerid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
