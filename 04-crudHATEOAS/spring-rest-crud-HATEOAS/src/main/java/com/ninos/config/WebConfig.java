package com.ninos.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ninos.convertToYaml.ConvertHttpToYaml;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("application/x-yaml");

	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new ConvertHttpToYaml());

	}

	@SuppressWarnings("deprecation")
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		  
		  
		  configurer.favorPathExtension(false) 
		  .favorParameter(false)
		  .ignoreAcceptHeader(false)
		  .useRegisteredExtensionsOnly(false)
		  .defaultContentType(MediaType.APPLICATION_JSON) 
		   .mediaType("json",MediaType.APPLICATION_JSON) 
		   .mediaType("xml", MediaType.APPLICATION_XML)
		   .mediaType("x-yaml", MEDIA_TYPE_YAML);
		 

	}

}
