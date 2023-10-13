package com.example.demo2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // 配置类
//@EnableWebMvc
@EnableSwagger2 // 开启 swagger2 的自动配置
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                // 配置基本信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/demo/**"))
                .build()
                .pathMapping("/");
    }


    // 基本信息设置
    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "灯火阑珊", // 作者姓名
                "https://nav.guidebook.top/", // 作者网址
                "renruiyx@163.com.com"); // 作者邮箱
        return new ApiInfoBuilder()
                .title("rr demo2-接口文档") // 标题
                .description("学习是人类进步的阶梯,所以不做人了") // 描述
                .termsOfServiceUrl("http://cxy521.com//") // 跳转连接
                .version("for chy") // 版本
                .license("Swagger-的使用(详细教程)")
                .licenseUrl("https://blog.csdn.net/xhmico/article/details/125353535")
                .contact(contact)
                .build();
    }


}

