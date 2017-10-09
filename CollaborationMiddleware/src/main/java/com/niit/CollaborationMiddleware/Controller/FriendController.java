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

import com.niit.CollaborationBackend.Dao.FriendDao;
import com.niit.CollaborationBackend.Model.Friend;

@RestController
public class FriendController 
{
@Autowired
FriendDao friendDao;

@GetMapping(value="/getAllFriend")
public ResponseEntity<ArrayList<Friend>> getAllFriend()
{
	ArrayList<Friend> listFriend=new ArrayList<Friend>();
	listFriend=(ArrayList<Friend>)friendDao.getFriend();
	return new ResponseEntity<ArrayList<Friend>>(listFriend,HttpStatus.OK);
}
@PostMapping(value="/CreateFriend")
public ResponseEntity<String> createFriend(@RequestBody Friend friend)
{
	
	friend.setFriend_Status("NA");
	if(friendDao.CreateFriend(friend))
	{
		return new ResponseEntity<String>("Friend Created",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem in Friend Creation",HttpStatus.NOT_ACCEPTABLE);
	}
}

@GetMapping(value="/approveFriend/{Friend_Id}")
public ResponseEntity<String> approveFriend(@PathVariable("Friend_Id")int Friend_Id)
{
	Friend friend=friendDao.getFriend(Friend_Id);
	if(friendDao.approveFriend(friend))
	{
		return new ResponseEntity<String>("Friend Approved",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem in Friend Approval",HttpStatus.NOT_ACCEPTABLE);
	}
}
@GetMapping(value="/deleteFriend/{Friend_Id}")
public ResponseEntity<String> deleteFriend(@PathVariable("Friend_Id")int Friend_Id)
{
if(friendDao.deleteFriend(Friend_Id))
{
	return new ResponseEntity<String>("Friend Deleted",HttpStatus.OK);
}
else
{
	return new ResponseEntity<String>("Problem in Deletion",HttpStatus.NOT_ACCEPTABLE);
}
}

@GetMapping(value="/test")
public ResponseEntity<String> testMethod()
{
	return new ResponseEntity<String>("Test RestController",HttpStatus.OK);
}

}
