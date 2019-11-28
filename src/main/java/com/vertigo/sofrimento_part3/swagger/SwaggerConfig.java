package com.vertigo.sofrimento_part3.swagger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vertigo.sofrimento_part3.exception.CustomErrorResponse;
import com.vertigo.sofrimento_part3.utils.Utils;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.vertigo.sofrimento_part3.controller"))
          .paths(PathSelectors.ant("/employee/*"))
          .build()
          .apiInfo(apiInfo())    
          .useDefaultResponseMessages(false)
          .globalResponseMessage(RequestMethod.GET, responseMessageForGET());
    }                                         
    
    
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Employee REST API", 
          "Some custom description of API.", 
          "API TOS", 
          "Terms of service", 
          new Contact("O Miranha", "www.vertigo.com.br", "omiranha@vertigo.com.br"), 
          "License of API", "API license URL", Collections.emptyList());
    }
	
	@SuppressWarnings("serial")
	private List<ResponseMessage> responseMessageForGET(){
	  return new ArrayList<ResponseMessage>() {{
	      add(new ResponseMessageBuilder()
	          .code(500)
	          .message("500 message")
	          .responseModel(new ModelRef("Error"))
	          .build());
	      add(new ResponseMessageBuilder()
		            .code(404)
		            .message(Utils.toJSON(new CustomErrorResponse()))
		            .responseModel(new ModelRef("Error"))
		            .build());
	      add(new ResponseMessageBuilder()
	          .code(403)
	          .message("Forbidden!")
	          .build());
	  }};
	}
    
}