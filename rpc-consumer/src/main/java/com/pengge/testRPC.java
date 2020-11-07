package com.pengge;

import com.pengge.api.UserService;
import com.pengge.dto.UserDTO;
import com.pengge.proxy.FactoryProxy;

public class testRPC {
    public static void main(String[] args) {
        UserService userService = FactoryProxy.getInstanceByClassType(UserService.class);

        UserDTO userDTO = new UserDTO();
        userDTO.setAge(18);
        userDTO.setName("David");

        UserDTO resUserDTO = userService.addUser(userDTO);
        System.out.println(resUserDTO);
    }
}
