package com.example.adressbook2;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
//@Configuration
//@EnableSwagger2
@SpringBootApplication
public class AdressBook2Application {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(AdressBook2Application.class, args);
	}
//	@Bean
//	public Docket swaggerConfiguration(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				//to get builder object-->apibuilder
//				.select()
//				.paths(PathSelectors.ant("/api/*"))
//				.apis(RequestHandlerSelectors.basePackage("com.example"))
//				.build()
//				.apiInfo();//builderobjet
//	}
//	private ApiInfo apiDetails(){
//		return new ApiInfo(
//				"Address book api",
//				"sample api for these project",
//				"1.0",
//				"free to use",
//				"Api license",
//				Collections.emptyList());
//
//
//	}

}
