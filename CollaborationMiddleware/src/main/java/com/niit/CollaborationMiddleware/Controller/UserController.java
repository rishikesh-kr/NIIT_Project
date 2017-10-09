package com.niit.CollaborationMiddleware.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackend.Dao.UserDao;
import com.niit.CollaborationBackend.Model.User;

@RestController
public class UserController 
{
@Autowired
UserDao userDao;

@GetMapping(value="/getAllUser")
public ResponseEntity<ArrayList<User>> getAllUser()
{
	ArrayList<User> listUser=new ArrayList<User>();
	listUser=(ArrayList<User>)userDao.getUser();
	return new ResponseEntity<ArrayList<User>>(listUser,HttpStatus.OK);
}

@PostMapping(value="/CreateUser")
public ResponseEntity<String> createUser(@RequestBody User user)
{
	user.setUser_Status("NA");;
	if(userDao.CreateUser(user))
	{
		return new ResponseEntity<String>("User Created",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem in User Creation",HttpStatus.NOT_ACCEPTABLE);
	}
}

@GetMapping(value="/approveUser/{UserId}")
public ResponseEntity<String> approveUser(@PathVariable("UserId")int UserId)
{
	User user=userDao.getUser(UserId);
	if(userDao.approveUser(user))
	{
		return new ResponseEntity<String>("User Approved",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem in User Approval",HttpStatus.NOT_ACCEPTABLE);
	}
}

@GetMapping(value="/deleteUser/{UserId}")
public ResponseEntity<String> deleteUser(@PathVariable("UserId")int UserId)
{
	if(userDao.deleteUser(UserId))
	{
		return new ResponseEntity<String>("User Deleted",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem in User Deletion",HttpStatus.NOT_ACCEPTABLE);
	}
}

@GetMapping(value="/test")
public ResponseEntity<String> testMethod()
{
	return new ResponseEntity<String>("Test RestController",HttpStatus.OK);
}

}
