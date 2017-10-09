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

import com.niit.CollaborationBackend.Dao.BlogCommentDao;
import com.niit.CollaborationBackend.Model.BlogComment;

@RestController
public class BlogCommentController 
{
@Autowired
BlogCommentDao blogCommentDao;

@GetMapping(value="/getAllBlogComment")
public ResponseEntity<ArrayList<BlogComment>> getAllBlogComment()
{
	ArrayList<BlogComment> listBlogComment=new ArrayList<BlogComment>();
	listBlogComment=(ArrayList<BlogComment>)blogCommentDao.getBlogComment();
	return new ResponseEntity<ArrayList<BlogComment>>(listBlogComment,HttpStatus.OK);
}

@PostMapping(value="/CreateBlogComment")
public ResponseEntity<String> createBlogComment(@RequestBody BlogComment blogComment)
{
	blogComment.setCommentDate(new java.util.Date());
    if(blogCommentDao.CreateBlogComment(blogComment))
    {
    	return new ResponseEntity<String>("BlogComment Created",HttpStatus.OK);
    }
    else
    {
    	return new ResponseEntity<String>("Problem in BlogComment Creation",HttpStatus.NOT_ACCEPTABLE);
    }
}

@GetMapping(value="/approveBlogComment/{Blogc_Id}")
public ResponseEntity<String> approveBlogComment(@PathVariable("Blogc_Id")int Blogc_Id)
{
	
	BlogComment blogComment=blogCommentDao.getBlogComment(Blogc_Id);
	if(blogCommentDao.approveBlogComment(blogComment))
	{
		return new ResponseEntity<String>("BlogComment Approved",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem in BlogComment Approval",HttpStatus.NOT_ACCEPTABLE);
	}
}

@GetMapping(value="/deleteBlogComment/{Blogc_Id}")
public ResponseEntity<String> deleteBlogComment(@PathVariable("Blogc_Id")int Blogc_Id)
{
	if(blogCommentDao.deleteBlogComment(Blogc_Id)) 
	{
	return new ResponseEntity<String>("BlogComment deleted",HttpStatus.OK);	
	}
	else
	{
		return new ResponseEntity<String>("Problem in BlogComment deletion",HttpStatus.NOT_ACCEPTABLE);
	}
}

@GetMapping(value="/test")
public ResponseEntity<String> testMethod()
{
	return new ResponseEntity<String>("Test RestController",HttpStatus.OK);
}
}
