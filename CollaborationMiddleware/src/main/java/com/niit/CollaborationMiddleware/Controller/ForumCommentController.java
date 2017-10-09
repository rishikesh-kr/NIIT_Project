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

import com.niit.CollaborationBackend.Dao.ForumCommentDao;
import com.niit.CollaborationBackend.Model.ForumComment;

@RestController
public class ForumCommentController 
{
	@Autowired
	ForumCommentDao forumCommentDao;
	
	@GetMapping(value="/getAllForumComment")
	public ResponseEntity<ArrayList<ForumComment>> getAllForumComment()
	{
		ArrayList<ForumComment> listForumComment=new ArrayList<ForumComment>();
		listForumComment=(ArrayList<ForumComment>)forumCommentDao.getForumComment();
		return new ResponseEntity<ArrayList<ForumComment>>(listForumComment,HttpStatus.OK);
	}
	
	@PostMapping(value="/CreateForumComment")
	public ResponseEntity<String> createForumComment(@RequestBody ForumComment forumComment)
	{
		forumComment.setCommentDate(new java.util.Date());
		if(forumCommentDao.CreateForumComment(forumComment))
		{
			return new ResponseEntity<String>("ForumComment Created",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in ForumComment Creation",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping(value="/approveForumComment/{Fc_Id}")
	public ResponseEntity<String> approveForumComment(@PathVariable("Fc_Id") int Fc_Id)
	{
		ForumComment forumComment=forumCommentDao.getForumComment(Fc_Id);
		if(forumCommentDao.approveForumComment(forumComment))
		{
			return new ResponseEntity<String>("ForumComment Approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in ForumComment Approval",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping(value="/deleteForumComment/{Fc_Id}")
	public ResponseEntity<String> deleteForumComment(@PathVariable("Fc_Id")int Fc_Id)
	{
		if(forumCommentDao.deleteForumComment(Fc_Id))
		{
			return new ResponseEntity<String>("ForumComment Deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in ForumComment Deletion",HttpStatus.NOT_ACCEPTABLE);
		}
	}
  @GetMapping(value="/test")
  public ResponseEntity<String> testMethod()
  {
	  return new ResponseEntity<String>("Test RestController",HttpStatus.OK);
  }
}
