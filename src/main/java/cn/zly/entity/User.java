package cn.zly.entity;


import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable {
    private String cn_user_id;
    private String cn_user_name;
    private String cn_user_password;
    private String cn_user_tonken;
    private String cn_user_nick;

    public String getCn_user_id() {
        return cn_user_id;
    }

    public void setCn_user_id(String cn_user_id) {
        this.cn_user_id = cn_user_id;
    }

    public String getCn_user_name() {
        return cn_user_name;
    }

    public void setCn_user_name(String cn_user_name) {
        this.cn_user_name = cn_user_name;
    }

    public String getCn_user_password() {
        return cn_user_password;
    }

    public void setCn_user_password(String cn_user_password) {
        this.cn_user_password = cn_user_password;
    }

    public String getCn_user_tonken() {
        return cn_user_tonken;
    }

    public void setCn_user_tonken(String cn_user_tonken) {
        this.cn_user_tonken = cn_user_tonken;
    }

    public String getCn_user_nick() {
        return cn_user_nick;
    }

    public void setCn_user_nick(String cn_user_nick) {
        this.cn_user_nick = cn_user_nick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(cn_user_id, user.cn_user_id) &&
                Objects.equals(cn_user_name, user.cn_user_name) &&
                Objects.equals(cn_user_password, user.cn_user_password) &&
                Objects.equals(cn_user_tonken, user.cn_user_tonken) &&
                Objects.equals(cn_user_nick, user.cn_user_nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cn_user_id, cn_user_name, cn_user_password, cn_user_tonken, cn_user_nick);
    }

    @Override
    public String toString() {

        return "User{" +
                "cn_user_id='" + cn_user_id + '\'' +
                ", cn_user_name='" + cn_user_name + '\'' +
                ", cn_user_password='" + cn_user_password + '\'' +
                ", cn_user_tonken='" + cn_user_tonken + '\'' +
                ", cn_user_nick='" + cn_user_nick + '\'' +
                '}';
    }
}
