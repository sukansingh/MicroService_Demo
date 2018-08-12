package com.micro.demo.MicroService_Demo.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveUserBean() {
		UserBean userBean = new UserBean(1,"John","password");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(userBean);
		
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfUserBean() {
		
		List<UserBean> userBeanList = Arrays.asList(new UserBean(1,"John","password"),
				new UserBean(2,"Jim","password"));
		
		MappingJacksonValue mapping = new MappingJacksonValue(userBeanList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
		FilterProvider filters = new SimpleFilterProvider().addFilter("UserBeanFilter", filter);
		mapping.setFilters(filters );
		
		return mapping;
	}
}
