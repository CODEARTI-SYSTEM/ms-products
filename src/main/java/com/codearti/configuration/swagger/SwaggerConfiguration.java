package com.codearti.configuration.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration extends WebMvcConfigurationSupport{

	/*
	 * @Bean public Docket createDocket() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.basePackage("com.codearti.controller"))
	 * .paths(PathSelectors.any()) .build() .apiInfo(apiInfo()); }
	 * 
	 * private ApiInfo apiInfo() { return new ApiInfoBuilder()
	 * .title("Rest Api Producto")
	 * .description("\"Rest Api para la gestion de productos\"") .version("v1.0")
	 * .termsOfServiceUrl("Terminos del servicio") .contact(new
	 * Contact("Eleazar Alfredo", "https://www.codearti.com",
	 * "ealfriadez@gmail.com")) .license("Apache License Version 2.0")
	 * .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	 * .extensions(Collections.emptyList()) .build(); }
	 * 
	 * @Override protected void addResourceHandlers(ResourceHandlerRegistry
	 * registry) { registry.addResourceHandler("/swagger-ui/**")
	 * .addResourceLocations(
	 * "classpath:/META-INF/resources/webjars/springfox-swagger-ui/"); }
	 */
	
	@Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.codearti.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Rest Api Producto")
                .description("\"Rest Api para la gestión de productos\"")
                .version("v1.0")
                .termsOfServiceUrl("Terminos del servicio")
                .contact(new Contact("Jean Ramal", "https://www.codearti.com", "contacto@codearti.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .extensions(Collections.emptyList())
                .build();
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/swagger-ui/**")
      .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }

}
