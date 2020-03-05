package com.hinton.staging.config;

import com.fasterxml.classmate.TypeResolver;
import com.hinton.staging.adapter.OutError;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Objects;

import static com.google.common.collect.Lists.newArrayList;

/******
 /*  @Description:
 /*  @author zzk
 /*  @date   2020/3/4 14:44
 ******/
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Autowired
    private TypeResolver typeResolver;
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                //这里是一个http请求头中的信息，如果需要的话可以再添加类似于apiKey()方法，加到下面的newArrayList()中
                .securitySchemes(newArrayList(apiKey()))
                .securityContexts(newArrayList(securityContext()))
                .useDefaultResponseMessages(true)
                .globalResponseMessage(RequestMethod.POST
                        , newArrayList(new ResponseMessageBuilder()
                                .code(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                                .message("常规错误")
                                .responseModel(new ModelRef("OutError"))
                                .build()))
                .globalResponseMessage(RequestMethod.PUT
                        , newArrayList(new ResponseMessageBuilder()
                                .code(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                                .message("常规错误")
                                .responseModel(new ModelRef("OutError"))
                                .build()))
                .additionalModels(typeResolver.resolve(OutError.class));
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("joc后台api")
                .build();
    }


    private ApiKey apiKey() {
        return new ApiKey("Authorization", "api_key", "header");
    }


    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                //一开始不需要token就可以访问的接口，类似于登录入口
                .forPaths((input) -> !input.startsWith("/my-test"))
                //不需要token就可以访问的接口
                .forPaths(input -> !Objects.equals("/sms", input))
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(
                new SecurityReference("Authorization", authorizationScopes));
    }
}
