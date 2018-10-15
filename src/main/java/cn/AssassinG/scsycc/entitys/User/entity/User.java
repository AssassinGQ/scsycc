package cn.AssassinG.scsycc.entitys.User.entity;

import cn.AssassinG.scsycc.common.entity.BaseEntity;

import java.util.Date;

public class User extends BaseEntity {
    private String UserName;
    private String PassWord;
    private String Phone;
    private String Vcode;
    private Date VcodeTime;
    private Boolean IsRegistered;
    private Integer UserType;
    private Long UserInfo;

    public User() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        this.PassWord = passWord;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getVcode() {
        return Vcode;
    }

    public void setVcode(String vcode) {
        Vcode = vcode;
    }

    public Date getVcodeTime() {
        return VcodeTime;
    }

    public void setVcodeTime(Date vcodeTime) {
        VcodeTime = vcodeTime;
    }

    public Boolean getRegistered() {
        return IsRegistered;
    }

    public void setRegistered(Boolean registered) {
        IsRegistered = registered;
    }

    public Integer getUserType() {
        return UserType;
    }

    public void setUserType(Integer userType) {
        UserType = userType;
    }

    public Long getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(Long userInfo) {
        UserInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Vcode='" + Vcode + '\'' +
                ", VcodeTime='" + VcodeTime + '\'' +
                ", id=" + id +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleteTime=" + deleteTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
