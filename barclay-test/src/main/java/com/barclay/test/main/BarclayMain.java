package com.barclay.test.main;

import com.barclay.test.config.AppConfig;
import com.barclay.test.controller.UserController;
import com.barclay.test.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description 启动类
 * @Author YIYAO
 * @Date 2018/3/12 17:41
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class BarclayMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserController userController = (UserController) ctx.getBean("userController");
        User user = userController.login("barclay", "1234");
        System.out.println(user.getAge());
    }
}
