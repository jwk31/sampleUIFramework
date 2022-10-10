package com.obtaincare.UI.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginPojo {
    private String userNameOrEmail;
    private String password;

}
