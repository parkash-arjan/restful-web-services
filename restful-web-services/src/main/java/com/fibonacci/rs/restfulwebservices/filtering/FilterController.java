package com.fibonacci.rs.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping("/filtering")
	public SomeBean getSomeBean() {
		//won't work because of filter proerty
		SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");	
		
		return someBean;
	}
	
	
	
	@GetMapping("/filtering1")
	public MappingJacksonValue getSomeFilterBean() {

		
		SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2", "value3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue jacksonValue = new MappingJacksonValue(someBean);
		jacksonValue.setFilters(filterProvider);
		
		return jacksonValue;
	}	
	
}
