package com.learn.components;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Profile {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String phone;

    public Profile() {

    }
}
