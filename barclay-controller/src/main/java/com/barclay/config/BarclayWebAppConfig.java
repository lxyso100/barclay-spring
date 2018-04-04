package com.barclay.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description
 * @Author YIYAO
 * @Date 2018/3/23 14:59
 * @Version V1.0
 * @Copyright: www.weilian.com Inc. All rights reserved.
 * 注意：本内容仅限于深圳象翌微链集团内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.barclay")
public class BarclayWebAppConfig implements WebMvcConfigurer {
    private final static Logger LOGGER = LoggerFactory.getLogger(BarclayWebAppConfig.class);

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setRequestContextAttribute("request");
        viewResolver.setCache(true);
        viewResolver.setSuffix(".ftl");
        registry.viewResolver(viewResolver);
        //不能设置requestContextAttribute
//        Map<String, Object> map = new HashMap<>();
//        map.put("request", "requestContextAttribute");
//        registry.freeMarker().attributes(map);
//        registry.freeMarker().cache(true).attributes(map).viewClass(FreeMarkerView.class);
        registry.jsp().prefix("/jsp/").suffix("").viewClass(JstlView.class);
        registry.enableContentNegotiation(new MappingJackson2JsonView());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = new ObjectMapper();
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
        converters.add(new ResourceHttpMessageConverter());
        converters.add(new ResourceRegionHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(new ByteArrayHttpMessageConverter());
        converters.add(new FormHttpMessageConverter());
        converters.add(new BufferedImageHttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true)
                .ignoreAcceptHeader(true)
                .parameterName("mediaType")
                .defaultContentType(MediaType.TEXT_HTML)
                .mediaType("html", MediaType.TEXT_HTML)
                .mediaType("json", MediaType.APPLICATION_JSON);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/app").setViewName("home");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/**");
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/freeMarker/");
        configurer.setDefaultEncoding("UTF-8");
        return configurer;
    }
}
