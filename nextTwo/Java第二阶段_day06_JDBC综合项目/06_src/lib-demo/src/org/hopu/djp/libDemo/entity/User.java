package org.hopu.djp.libDemo.entity;

// 用户实体类，对应数据库表名为 lib_user
public class User extends BaseEntity{
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userRealname;
    private String userAddress;
    private String userType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "createTime=" + createTime +
                ", createOpr=" + createOpr +
                ", updateTime=" + updateTime +
                ", updateOpr=" + updateOpr +
                ", enableFlag=" + enableFlag +
                ", deleteFlag=" + deleteFlag +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRealname='" + userRealname + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
