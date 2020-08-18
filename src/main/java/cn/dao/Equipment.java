package cn.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Date;
public class Equipment {
    /**
     * 装备实体类
     * 对应信息为序号，编号，名称，型号，地址，状态，时间
     */
    String snum,cid,eqname,mode,address,attribute;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date createtime;
    /**
     * 无参构造函数
     *
     */
    public Equipment(){}
    /**
     * 有参构造函数
     * @param snum
     * @param cid
     * @param eqname
     * @param address
     * @param attribute
     * @param createtime
     */
    public Equipment(String snum, String cid, String eqname, String mode, String address, String attribute, Date createtime) {
        this.snum = snum;
        this.cid = cid;
        this.eqname = eqname;
        this.mode = mode;
        this.address = address;
        this.attribute = attribute;
        this.createtime = createtime;
    }
    /**
     * 不带时间的有参构造函数
     * @param snum
     * @param cid
     * @param eqname
     * @param address
     * @param attribute

     */
    public Equipment(String snum, String cid, String eqname, String mode, String address, String attribute) {
        this.snum = snum;
        this.cid = cid;
        this.eqname = eqname;
        this.mode = mode;
        this.address = address;
        this.attribute = attribute;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getEqname() {
        return eqname;
    }

    public void setEqname(String eqname) {
        this.eqname = eqname;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
