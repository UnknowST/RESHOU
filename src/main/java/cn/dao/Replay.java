package cn.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.sql.Date;
public class Replay {
    /**
     * 回复信息实体类
     * 对应信息为序号，恢复维修单的账号，恢复工人账号，详细信息，恢复时间
     */
    String cid,sid,renum,detail;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    Date createdate;
    /**
     * 无参构造函数
     */
    public Replay (){}
    /**
     * 有参构造函数
     * @param cid
     * @param sid
     * @param  renum
     * @param detail
     * @param createdate
     */
    public Replay(String cid, String sid, String renum, String detail, Date createdate) {
        this.cid = cid;
        this.sid = sid;
        this.renum = renum;
        this.detail = detail;
        this.createdate = createdate;
    }
    /**
     * 不带时间有参构造函数
     * @param cid
     * @param sid
     * @param  renum
     * @param detail

     */

    public Replay(String cid, String sid, String renum, String detail) {
        this.cid = cid;
        this.sid = sid;
        this.renum = renum;
        this.detail = detail;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getRenum() {
        return renum;
    }

    public void setRenum(String renum) {
        this.renum = renum;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
