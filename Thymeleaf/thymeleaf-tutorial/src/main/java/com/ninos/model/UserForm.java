package com.ninos.model;

import lombok.Data;

@Data
public class UserForm {
    private String name;
    private String email;
    private String password;
    private String gender;
    private String address;
    private boolean married;
    private String profession;
}
