package com.fibonacci.rs.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

	@GetMapping("/filtering")
	public SomeBean getSomeBean() {
		SomeBean someBean = new SomeBean("Value1", "Value2", "Value3");
		return someBean;
	}
}
