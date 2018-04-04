package com.barclay.controller;

import com.barclay.service.UserService;
import com.barclay.model.UserInfo;
import com.sun.deploy.net.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description 用户controler
 * @Author YIYAO
 * @Date 2018/3/12 17:03
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    /**
     *
     * @param name
     * @param password
     * @return
     */
    @GetMapping(value = "login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
//    public Result login(@ModelAttribute("name") String name, String password, HttpSession session) {
    public Result login(String name, String password, HttpSession session) {
        LOGGER.debug("登陆接口");
        try {
            UserInfo userInfo = userService.login(name, password);
            session.setAttribute("sessionId", session.getId());
            return Result.createSuccess(userInfo);
        } catch (Exception e) {
            LOGGER.error("错误");
            return Result.createFailed();
        }
    }

    @GetMapping(value = "home")
    public ModelAndView home(Model model) {
        ModelAndView mav= new ModelAndView("home");
        mav.addObject("msg", "测试");
        return mav;
    }

    @RequestMapping("/hello")
    public String helloWorld(Model model, HttpServletResponse response, HttpSession session) {
        Cookie cookie = new Cookie("sessionId", session.getId());
        Cookie cookie2 = new Cookie("sessionId2", session.getId());
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.addHeader("sessionId", session.getId());
        String word0 = "Hello ";
        String word1 = "World!";
        //将数据添加到视图数据容器中
        model.addAttribute("word0",word0);
        model.addAttribute("word1",word1);
        return "hello";
    }


}
