package com.barclay.controller;

import com.barclay.exception.BusinessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author YIYAO
 * @Date 2018/3/27 10:03
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
@ControllerAdvice
public class BaseControllerAdvice {
    public String checkLogin() {
       return "";
    }
    @ModelAttribute
    public void init(Model model, @CookieValue(name = "JSESSIONID", required = false) String JSESSIONID, @RequestHeader(name = "sessionId", required = false) String sessionId) {
//        if(sessionId == null || sessionId.trim() == "")
        model.addAttribute("name", "123");
    }

    @ExceptionHandler(Exception.class)
    public Result handle(Exception e){
        return Result.createFailed(e.getMessage());
    }

}
