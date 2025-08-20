package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppController {
	@Autowired
  DAO dao;
  @GetMapping("/")
  public String fun1()
  {
    return "Welcome";
  }
  
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public String fun2(@RequestBody String user)
  {
    return "springboot response " + user;
  }
  
  @RequestMapping(value = "/bunny", method = RequestMethod.POST)
  public String fun(@RequestBody User user)
  {
	  System.out.println("controller");
    return "Data Inserted " + dao.insertUser(user);
  }
  @GetMapping("/all")
  public List<User> fun3() {
	  return dao.reteriveAll();
  }
  @GetMapping("/email")
  public String fun4(@RequestParam("email") String email)
  {
	  return dao.findUser(email).toString(); 	  
  }
  @DeleteMapping("/delete")
  public String fun5(@RequestParam("email") String email) {
	  return dao.deleteUser(email);
  }
  @PutMapping("/update")
  public String fun6(@RequestBody User user)
  {
	  return dao.updateUser(user);
  }
  





}