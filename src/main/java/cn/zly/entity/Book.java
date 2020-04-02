package cn.zly.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Book implements Serializable {
    private String cn_notebook_id;
    private String cn_user_id;
    private String cn_notebook_type_id;
    private String cn_notebook_name;
    private String cn_notebook_desc;
    private Integer cn_notebook_status;
    private Timestamp cn_notebook_createtime;
    private Timestamp cn_notebook_updatetime;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCn_notebook_status() {
        return cn_notebook_status;
    }

    public void setCn_notebook_status(Integer cn_notebook_status) {
        this.cn_notebook_status = cn_notebook_status;
    }

    public Timestamp getCn_notebook_updatetime() {
        return cn_notebook_updatetime;
    }

    public void setCn_notebook_updatetime(Timestamp cn_notebook_updatetime) {
        this.cn_notebook_updatetime = cn_notebook_updatetime;
    }

    public String getCn_notebook_id() {
        return cn_notebook_id;
    }

    public void setCn_notebook_id(String cn_notebook_id) {
        this.cn_notebook_id = cn_notebook_id;
    }

    public String getCn_user_id() {
        return cn_user_id;
    }

    public void setCn_user_id(String cn_user_id) {
        this.cn_user_id = cn_user_id;
    }

    public String getCn_notebook_type_id() {
        return cn_notebook_type_id;
    }

    public void setCn_notebook_type_id(String cn_notebook_type_id) {
        this.cn_notebook_type_id = cn_notebook_type_id;
    }

    public String getCn_notebook_name() {
        return cn_notebook_name;
    }

    public void setCn_notebook_name(String cn_notebook_name) {
        this.cn_notebook_name = cn_notebook_name;
    }

    public String getCn_notebook_desc() {
        return cn_notebook_desc;
    }

    public void setCn_notebook_desc(String cn_notebook_desc) {
        this.cn_notebook_desc = cn_notebook_desc;
    }

    public Timestamp getCn_notebook_createtime() {
        return cn_notebook_createtime;
    }

    public void setCn_notebook_createtime(Timestamp cn_notebook_createtime) {
        this.cn_notebook_createtime = cn_notebook_createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(cn_notebook_id, book.cn_notebook_id) &&
                Objects.equals(cn_user_id, book.cn_user_id) &&
                Objects.equals(cn_notebook_type_id, book.cn_notebook_type_id) &&
                Objects.equals(cn_notebook_name, book.cn_notebook_name) &&
                Objects.equals(cn_notebook_desc, book.cn_notebook_desc) &&
                Objects.equals(cn_notebook_createtime, book.cn_notebook_createtime) &&
                Objects.equals(user, book.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cn_notebook_id, cn_user_id, cn_notebook_type_id, cn_notebook_name, cn_notebook_desc, cn_notebook_createtime, user);
    }

    @Override
    public String toString() {
        return "Book{" +
                "cn_notebook_id='" + cn_notebook_id + '\'' +
                ", cn_user_id='" + cn_user_id + '\'' +
                ", cn_notebook_type_id='" + cn_notebook_type_id + '\'' +
                ", cn_notebook_name='" + cn_notebook_name + '\'' +
                ", cn_notebook_desc='" + cn_notebook_desc + '\'' +
                ", cn_notebook_status=" + cn_notebook_status +
                ", cn_notebook_createtime=" + cn_notebook_createtime +
                ", cn_notebook_updatetime=" + cn_notebook_updatetime +
                ", user=" + user +
                '}';
    }
}
