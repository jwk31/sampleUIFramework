package com.obtaincare.UI.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserPojo {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String userName;
    private String password;
    private String bio;
    private String userType;
    private String timeZone;
    private String language;

}
