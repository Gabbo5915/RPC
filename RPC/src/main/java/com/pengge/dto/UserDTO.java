package com.pengge.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -8032564224302904539L;
    private String name;
    private int age;
    private String userID;
}
