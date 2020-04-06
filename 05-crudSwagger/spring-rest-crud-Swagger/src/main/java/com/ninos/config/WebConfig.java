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

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

		// go to the postman
		// Headers : key:accept value:application/json or xml

		/*
		 * http://localhost:8080/person.xml
		 * 
		 * configurer.favorParameter(false) .ignoreAcceptHeader(false)
		 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 * MediaType.APPLICATION_JSON) .mediaType("xml",MediaType.APPLICATION_XML );
		 */

		/*
		 * http://localhost:8080/person?mediaType=xml
		 * 
		 * configurer.favorPathExtension(false) .favorParameter(true)
		 * .parameterName("mediaType") .ignoreAcceptHeader(true)
		 * .useRegisteredExtensionsOnly(false)
		 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
		 */

		
		  
		  
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
