package com.micro.demo.MicroService_Demo.Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		PersonV1 person = new PersonV1("John D'Souza");
		
		return person;
	}
	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		PersonV2 person = new PersonV2(new Name("John" ,"D'Souza"));
		
		return person;
	}
	
	@GetMapping(value="/person", params="version=1")
	public PersonV1 personParamV1() {
		PersonV1 person = new PersonV1("John D'Souza");
		
		return person;
	}
	@GetMapping(value="/person", params="version=2")
	public PersonV2 personParamV2() {
		PersonV2 person = new PersonV2(new Name("John" ,"D'Souza"));
		
		return person;
	}
	
	@GetMapping(value="/person", headers="X-API-VERSION=1")
	public PersonV1 personHeaderV1() {
		PersonV1 person = new PersonV1("John D'Souza");
		
		return person;
	}
	@GetMapping(value="/person", headers="X-API-VERSION=2")
	public PersonV2 personHeaderV2() {
		PersonV2 person = new PersonV2(new Name("John" ,"D'Souza"));
		
		return person;
	}
	
	@GetMapping(value="/person", produces="application/vnd.company.app-v1+json")
	public PersonV1 personProducesV1() {
		PersonV1 person = new PersonV1("John D'Souza");
		
		return person;
	}
	@GetMapping(value="/person", produces="application/vnd.company.app-v2+json")
	public PersonV2 personProducesV2() {
		PersonV2 person = new PersonV2(new Name("John" ,"D'Souza"));
		
		return person;
	}
}
