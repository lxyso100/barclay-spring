package com.barclay.test.config;

import com.barclay.test.model.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 无xml配置
 * @Author YIYAO
 * @Date 2018/3/12 17:14
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
@ComponentScan({"com.barclay"})
//@ComponentScans({@ComponentScan("com.barclay"), @ComponentScan("com.barclay")})
public class AppConfig {
}
