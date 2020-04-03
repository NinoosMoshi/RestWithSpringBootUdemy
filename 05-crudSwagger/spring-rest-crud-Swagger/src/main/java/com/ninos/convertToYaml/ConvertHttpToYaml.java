package com.ninos.convertToYaml;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class ConvertHttpToYaml extends AbstractJackson2HttpMessageConverter {

	public ConvertHttpToYaml() {
		super(new YAMLMapper(),MediaType.parseMediaType("application/x-yaml"));
		
	}

}
