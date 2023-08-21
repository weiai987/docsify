package com.blb.bookms.entity;


public class User {

  private long id;
  private String username;
  private String password;
  private String realname;
  private String pid;
  private long point;


  public long getId() {
    return id;
  }

  public void setId(long id) {
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


  public String getRealname() {
    return realname;
  }

  public void setRealname(String realname) {
    this.realname = realname;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public long getPoint() {
    return point;
  }

  public void setPoint(long point) {
    this.point = point;
  }

}
