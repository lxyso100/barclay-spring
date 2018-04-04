package com.barclay.main;

import com.barclay.controller.UserController;
import com.barclay.model.UserInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        //注解方式
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class); //扫描配置类
//        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.barclay"); //直接扫描包
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.scan("com.barclay");
//        ctx.register(AppConfig.class);
//        ctx.refresh();
        //xml方式
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
//        ctx.setConfigLocation("application.xml");
//        ctx.refresh();


//        UserController userController = (UserController) ctx.getBean("userController");
//        UserController userController = ctx.getBean(UserController.class);
//        UserInfo userInfo = userController.login("barclay", "123");
//        System.out.println(userInfo.getAge());

//        ctx.registerShutdownHook();
//        ctx.start();
    }
}
