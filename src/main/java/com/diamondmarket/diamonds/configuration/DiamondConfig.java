package com.diamondmarket.diamonds.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.diamondmarket.diamonds.api.DiamondApi;
import com.diamondmarket.diamonds.api.DiamondApiController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DiamondConfig {

	 ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	            .title("DiamondDB Service")
	            .description("This is diamond database Swagger.")
	            .license("")
	            .licenseUrl("http://unlicense.org")
	            .termsOfServiceUrl("")
	            .version("1.0.0")
	            .contact(new Contact("","", ""))
	            .build();
	    }

	    @Bean
	    public Docket customImplementation(){
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                    .apis(RequestHandlerSelectors.basePackage("com.diamondmarket.diamonds.api"))
	                    .build()
	                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
	                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
	                .apiInfo(apiInfo());
	    }
}
