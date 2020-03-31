package com.ninos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		configurer.favorParameter(false)
		          .ignoreAcceptHeader(false)                        // do not accept header
		          .defaultContentType(MediaType.APPLICATION_JSON)   // it is meaning default type will be JSON
		          .mediaType("json", MediaType.APPLICATION_JSON)    // you can make a project JSON
		          .mediaType("xml",MediaType.APPLICATION_XML );     // you can make a project XML
		
	}

}
