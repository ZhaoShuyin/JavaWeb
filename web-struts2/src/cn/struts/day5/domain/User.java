package cn.struts.day5.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class User implements Serializable {
    private Integer id;//尽量使用基本类型的包装类型
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private Date birthday;
    private String degrees;
    private String phonenum;
    private String hobby;
    private String path;
    private String filename;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", nickname=" + nickname + ", gender=" + gender
                + ", birthday=" + birthday + ", degrees=" + degrees
                + ", phonenum=" + phonenum + ", hobby=" + hobby + ", path="
                + path + ", filename=" + filename + ", description="
                + description + "]";
    }

}
