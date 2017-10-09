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

import com.niit.CollaborationBackend.Dao.ForumDao;
import com.niit.CollaborationBackend.Model.Forum;

@RestController
public class ForumController 
{
@Autowired
ForumDao forumDao;

@GetMapping(value="/getAllForum")
public ResponseEntity<ArrayList<Forum>> getAllForum()
{
	ArrayList<Forum> listForum=new ArrayList<Forum>();
	listForum=(ArrayList<Forum>)forumDao.getForum();
	return new ResponseEntity<ArrayList<Forum>>(listForum,HttpStatus.OK);
}
	@PostMapping(value="/CreateForum")
	public ResponseEntity<String> createForum(@RequestBody Forum forum)
	{
		forum.setCreateDate(new java.util.Date());
		forum.setForum_Status("NA");
		if(forumDao.CreateForum(forum))
		{
			return new ResponseEntity<String>("Forum Created",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Forum Creation",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping(value="/approveForum/{Forum_Id}")
	public ResponseEntity<String> approveForum(@PathVariable ("Forum_Id") int Forum_Id)
	{
		Forum forum=forumDao.getForum(Forum_Id);
		if(forumDao.approveForum(forum))
		{
			return new ResponseEntity<String>("Forum Approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Forum Approval",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping(value="/deleteForum/{Forum_Id}")
	public ResponseEntity<String> deleteForum(@PathVariable("Forum_Id") int Forum_Id)
	{
		if(forumDao.deleteForum(Forum_Id))
		{
			return new ResponseEntity<String>("Forum Deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Forum Deletion",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping(value="/test")
	 public ResponseEntity<String> testMethod()
	 {
		 return new ResponseEntity<String>("Test RestController",HttpStatus.OK);
	 }
}
