package com.example.demo.obj;

import java.util.Date;

public class UserDto {
  private Long id;
  private String username;
  private String password;
  private String status;
  
  public UserDto(Long id, String username, String password, String status) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.status = status;
  }
  

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public Date getUpdateDate() {
    return updateDate;
  }
  
  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
  
  public Date getCreateDate() {
    return createDate;
  }
  
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  
  public Date getDeleteDate() {
    return deleteDate;
  }
  
  public void setDeleteDate(Date deleteDate) {
    this.deleteDate = deleteDate;
  }
}
