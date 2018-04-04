package com.barclay.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Description
 * @Author YIYAO
 * @Date 2018/3/22 15:36
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
public class BarclayWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    private final static Logger LOGGER = LoggerFactory.getLogger(BarclayWebApplicationInitializer.class);
    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{BarclayAppConfig.class};
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{BarclayWebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        String url = "/app/*";
        LOGGER.debug("指定前置控制器入口:[{}]", url);
        return new String[]{url};
    }
}
