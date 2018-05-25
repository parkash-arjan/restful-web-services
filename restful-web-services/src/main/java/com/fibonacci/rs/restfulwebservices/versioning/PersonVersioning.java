package com.fibonacci.rs.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;

public class PersonVersioning {

	// http://localhost:8080/person/param?version=1
	@GetMapping(value = "/person/param", params = "version=1")
	public Person parmV1() {

		return null;
	}

	// http://localhost:8080/person/param?version=2
	@GetMapping(value = "/person/param", params = "version=2")
	public Person parmV2() {

		return null;
	}

	// http://localhost:8080/person/header?version=1
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public Person headerV1() {

		return null;
	}

	// http://localhost:8080/person/header?version=2
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public Person headerV2() {

		return null;
	}

	
	
	
//header parameter
	// http://localhost:8080/person/produces?version=1
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public Person producesV1() {

		return null;
	}

	// http://localhost:8080/person/produces?version=2
	//passed with accept in header or MIME type version
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public Person producesV2() {

		return null;
	}
	
}
