package com.example.artsell;

import java.nio.charset.Charset;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class ArtsellBootApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ArtsellBootApplication.class, args);
	}

	@Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

	/*
	 * @Bean public Filter characterEncodingFilter() { CharacterEncodingFilter
	 * characterEncodingFilter = new CharacterEncodingFilter();
	 * characterEncodingFilter.setEncoding("UTF-8");
	 * characterEncodingFilter.setForceEncoding(true); return
	 * characterEncodingFilter; }
	 */
}
