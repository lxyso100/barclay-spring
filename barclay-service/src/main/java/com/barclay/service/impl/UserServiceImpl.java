package com.barclay.service.impl;

import com.barclay.service.UserService;
import com.barclay.model.UserInfo;
import org.springframework.stereotype.Service;

/**
 * @Description 用户实现类
 * @Author YIYAO
 * @Date 2018/3/12 17:05
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserInfo login(String name, String password) throws Exception{
        if(!"123".equals(password)) throw new Exception("密码错误");
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setPassword(password);
        userInfo.setAge(18);
        return userInfo;
    }
}
