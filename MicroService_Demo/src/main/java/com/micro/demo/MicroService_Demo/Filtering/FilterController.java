package com.micro.demo.MicroService_Demo.Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

	@GetMapping("/filtering")
	public UserBean retrieveUserBean() {
		return new UserBean(1,"John","password");
	}
	
	@GetMapping("/filtering-list")
	public List<UserBean> retrieveListOfUserBean() {
		return Arrays.asList(new UserBean(1,"John","password"),
				new UserBean(2,"Jim","password"));
	}
}
