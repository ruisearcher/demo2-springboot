package com.example.demo2.config;

import com.example.demo2.interceptor.LoginHandler;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/5/26 15:24
 */
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        //http://localhost:8666/swagger-ui.html#
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        //addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册Interceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginHandler());

        registration.addPathPatterns("/**"); //所有路径都被拦截

        registration.excludePathPatterns( //添加不拦截路径
                "/demo/user/login", //登录页面
                //"/user/login",       //登录请求
                "/**/*.html",   //html静态资源
                "/**/*.js",     //js静态资源
                "/**/*.css"     //css静态资源
        );
    }
}
