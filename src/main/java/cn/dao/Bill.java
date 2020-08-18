package cn.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Date;
public class Bill {
    /**
     * 账单实体类
     * 对应信息为 序号，账单号，花费，地点，使用者，时间
     */
    String snum,num,cost,place,useing;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date createtime;
    /**
     * 无参构造函数
     */
    public Bill(){}
    /**
     * 有参构造函数
     * @param snum
     * @param num
     * @param cost
     * @param place
     * @param useing
     * @param createtime
     */
    public Bill(String snum, String num, String cost, String place, String useing, Date createtime) {
        this.snum = snum;
        this.num = num;
        this.cost = cost;
        this.place = place;
        this.useing = useing;
        this.createtime = createtime;
    }
    /**
     * 不带时间的有参构造函数
     * @param snum
     * @param num
     * @param cost
     * @param place
     * @param useing

     */
    public Bill(String snum, String num, String cost, String place, String useing) {
        this.snum = snum;
        this.num = num;
        this.cost = cost;
        this.place = place;
        this.useing = useing;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUseing() {
        return useing;
    }

    public void setUseing(String useing) {
        this.useing = useing;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
