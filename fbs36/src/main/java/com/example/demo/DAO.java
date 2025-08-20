package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DAO {
	@Autowired
	UserInterface repo;
   public User insertUser(User user)
   {
	   System.out.println("dao");
	   return repo.save(user);
   }
   public List<User> reteriveAll()
   {
	   return repo.findAll();
   }
   public User findUser(String email) {
	   return repo.findByEmail(email);
   }
   public String deleteUser(String email) {
	  repo.delete(findUser(email));
	  return "Deleted "+email;
   }
   public String updateUser(User user) {
       deleteUser(user.getEmail());
       insertUser(user);
       return "Updated"+user.getEmail();
   }

}
