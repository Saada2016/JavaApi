package io.javabrains.springbootstarter.user;


import java.util.ArrayList;
import java.util.Date;
//import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.product.Product;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		userRepository.findAll()
		.forEach(users::add);
		return users;
	}
	
	public User getUser(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public User addUser(User user) {
//		userRepository.save(user);	
		if(user.getId()==null) {
			user.setCreatedOn(new Date());
			user.setCreatedBy(new Date());
			user.setUpdatedOn(new Date());
			user.setUpdatedBy(new Date());
		}
		else
		{
			User updateUser =userRepository.findById(user.getId()).orElse(null);
			user.setCreatedOn(updateUser.getCreatedOn());
			user.setCreatedBy(updateUser.getCreatedBy());
			user.setUpdatedOn(updateUser.getUpdatedOn());
			user.setUpdatedBy(updateUser.getUpdatedBy());
			user.setUpdatedOn(new Date());
		}
		 return userRepository.save(user);
	}

//	public void updateUser(Long id, User user) {	
//		if(user.getId()== id) {
//			user.setCreatedOn(new Date());
//			user.setCreatedBy(new Date());
//			user.setUpdatedOn(new Date());
//			user.setUpdatedBy(new Date());
//		}
//		else
//		{
//			User updateUser =userRepository.findById(user.getId()).orElse(null);
//			user.setCreatedOn(updateUser.getCreatedOn());
//			user.setCreatedBy(updateUser.getCreatedBy());
//			user.setUpdatedOn(updateUser.getUpdatedOn());
//			user.setUpdatedBy(updateUser.getUpdatedBy());
//			user.setUpdatedOn(new Date());
//		}
//		userRepository.save(user);
//
//	}

	public void deleteUser(Long id) {
//		Optional<User> updateUser = userRepository.findById(user.getId());
		userRepository.deleteById(id);
	}

}
