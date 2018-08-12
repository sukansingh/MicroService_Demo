package com.micro.demo.MicroService_Demo.Controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.AjAttribute.MethodDeclarationLineNumberAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.micro.demo.MicroService_Demo.customexception.UserNotFoundException;
import com.micro.demo.MicroService_Demo.dao.UserDAOService;
import com.micro.demo.bean.User;

@RestController
public class UserController {

	@Autowired
	private UserDAOService userDAOService;
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		return userDAOService.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id){
		User user =  userDAOService.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);
		
		//HATEOAS - HyperMedia As The Engine Of Application State
		Resource<User> resource = new Resource<User>(user);
		Link link = linkTo(methodOn(this.getClass()).retrieveAllUsers()).withRel("all-users");
		resource.add(link);
		
		
		return resource;
	}
	
	@PostMapping(path="/user")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		userDAOService.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path="/user/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable int id){
		User user =  userDAOService.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id-"+id);	
		return ResponseEntity.noContent().build();
	}
}
