//package com.example.demo.service;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.User;
//import com.example.demo.obj.UserDto;
//import com.example.demo.repository.UserRepository;
//
//@Service
//public class UserService {
//
//  @Autowired
//  private UserRepository userRepository;
//
//  public List<UserDto> searchAll() {
//    List<User> userList = userRepository.findAll();
//    List<UserDto> userDtoList = new ArrayList<>();
//
//    for (User user : userList) {
//      UserDto userDto = convertToDto(user);
//      userDtoList.add(userDto);
//    }
//
//    return userDtoList;
//  }
//
//  private UserDto convertToDto(User user) {
//    Long id = user.getId();
//    String name = user.getName();
//    String address = user.getAddress();
//    String phone = user.getPhone();
//    Date updateDate = user.getUpdateDate();
//    Date createDate = user.getCreateDate();
//    Date deleteDate = user.getDeleteDate();
//
//    return new UserDto(id, name, address, phone, updateDate, createDate, deleteDate);
//  }
//}
