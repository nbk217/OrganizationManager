package com.demo;

import com.demo.servlet.CountryServlet;
import com.demo.servlet.WelcomeServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.util.Arrays;

@SpringBootApplication
public class OrgManagerApplication {

	@Value("${file.upload.size.max}")
	private Integer fileUploadSizeMax;

//	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(
				new CountryServlet(), "/country");
		return bean;
	}

	@Bean
	public ServletRegistrationBean welcomeServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(
				new WelcomeServlet(), "/welcome");
		return bean;
	}

	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(mapper);
		return converter;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(fileUploadSizeMax);
		return multipartResolver;

	}

	@Bean
	public StandardServletMultipartResolver standardServletMultipartResolver() {
		return new StandardServletMultipartResolver();
	}


	public static void main(String[] args) {

		SpringApplication.run(OrgManagerApplication.class, args);
	}

}

