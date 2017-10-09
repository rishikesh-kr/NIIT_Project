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

import com.niit.CollaborationBackend.Dao.BlogDao;
import com.niit.CollaborationBackend.Model.Blog;

@RestController
public class BlogController 
{
 @Autowired
 BlogDao blogDao;
	
	@GetMapping(value="/getAllBlog")
	public ResponseEntity<ArrayList<Blog>> getAllBlog()
	{
		ArrayList<Blog> listBlog=new ArrayList<Blog>();
		listBlog=(ArrayList<Blog>)blogDao.getBlog();
		return new ResponseEntity<ArrayList<Blog>>(listBlog,HttpStatus.OK);
	}
	
	@PostMapping(value="/CreateBlog")
	public ResponseEntity<String> createBlog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		blog.setBlog_Status("NA");
		blog.setLikes(0);
		if(blogDao.CreateBlog(blog))
		{
			return new ResponseEntity<String>("Blog Created",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Blog creation",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping(value="/approveBlog/{Blog_Id}")
	public ResponseEntity<String> approveBlog(@PathVariable("Blog_Id") int Blog_Id)
	{
		Blog blog=blogDao.getBlog(Blog_Id);
		if(blogDao.approveBlog(blog))
		{
			return new ResponseEntity<String>("Blog Approved",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Blog approval",HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping(value="/deleteBlog/{Blog_Id}")
	public ResponseEntity<String> deleteBlog(@PathVariable("Blog_Id") int Blog_Id)
	{
	if(blogDao.deleteBlog(Blog_Id))
	{
		return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Problem in Blog deletion",HttpStatus.NOT_ACCEPTABLE);
	}
	
	}
	
	@GetMapping(value="/test")
 public ResponseEntity<String> testMethod()
 {
	 return new ResponseEntity<String>("Test RestController",HttpStatus.OK);
 }
}
