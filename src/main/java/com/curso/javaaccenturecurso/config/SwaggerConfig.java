package com.curso.javaaccenturecurso.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.curso.javaaccenturecurso")).paths(regex("/api.*")).build()
				.apiInfo(metaInfo());

	}

	@SuppressWarnings("rawtypes")
	public ApiInfo metaInfo() {
		ApiInfo info = new ApiInfo("Api REST",
				"Cadastro de Produtos",
				"1.0",
				"Terms Sevice",
				new Contact("Emerson Barros",
						"kaua54@hotmail.com","https://github.com/barrosEmerson"),
				"Apache Licence 2.0",
				"https://www.apache.org/license.html", new ArrayList<VendorExtension>());
		return info;
	}
}