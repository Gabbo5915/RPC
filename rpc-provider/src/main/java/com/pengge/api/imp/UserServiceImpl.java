package com.pengge.api.imp;

import com.pengge.api.UserService;
import com.pengge.dto.UserDTO;

import java.util.Random;

public class UserServiceImpl implements UserService {
    public UserDTO addUser(UserDTO userDTO) {
        System.out.println("Received: "+userDTO);
        userDTO.setUserID(new Random().nextInt(10000000)+"");
        System.out.println("Received: "+userDTO);
        return userDTO;
    }
}
