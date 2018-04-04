package com.barclay.test.servcie;

import com.barclay.test.model.User;

/**
 * @Description 用户接口
 * @Author YIYAO
 * @Date 2018/3/12 17:04
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
public interface UserService {
    /**
     * 用户登陆
     * @param name 名称
     * @param password 密码
     * @return 用户实体类
     */
    User login(String name, String password) throws Exception;
}
