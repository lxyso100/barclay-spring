package com.barclay.test.controller;

import com.barclay.test.model.User;
import com.barclay.test.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * @Description 用户controler
 * @Author YIYAO
 * @Date 2018/3/12 17:03
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public User login(String name, String password) {
        try {
            return userService.login(name, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
}
