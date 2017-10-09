package com.niit.CollaborationBackend.Test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackend.Dao.BlogDao;
import com.niit.CollaborationBackend.Model.Blog;

import junit.framework.TestCase;


public class BlogDaoTestCase extends TestCase 
{
  static BlogDao blogDao;
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit.CollaborationBackend");
		annotationConfigApplicationContext.refresh();
		blogDao =(BlogDao)annotationConfigApplicationContext.getBean("blogDao");
	}
	@Test
	public void testCreateBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlog_Id(1001);
		blog.setBlog_Name("Selenium");
		blog.setBlog_Content("Selenium is a testing tool");
		blog.setBlog_Status("NA");
		blog.setBlog_Username("Madhu");
		blog.setLikes(0);
		blog.setCreateDate(new java.util.Date());
//		assertTrue("Problem in Blog Creation",blogDao.CreateBlog(blog));
	}
	
	@Test
	@Ignore
	public void approveBlogTest()
	{
		Blog blog=new Blog();
		blog.setBlog_Id(1001);
		blog.setBlog_Name("Selenium");
		blog.setBlog_Content("Selenium is a testing tool");
		blog.setBlog_Status("NA");
		blog.setBlog_Username("Madhu");
		blog.setLikes(0);
		blog.setCreateDate(new java.util.Date());
		assertTrue("Problem in Approving Blog",blogDao.approveBlog(blog));
	}
	@Test
	@Ignore
	public void getAllApprovedBlogTest()
	{
		List<Blog> listBlog =blogDao.getBlog();
		assertTrue("No Approved Blog",listBlog.size()>0);	
	}
	 @Test
	 @Ignore
	 public void deleteBlogTest()
	 {
		 assertTrue("Problem in Deleting",blogDao.deleteBlog(1001));
	 }
	 
	 @Test
	 @Ignore
	 public void getBlogByBlodId()
	 {
		 assertNotNull("Problem getting blog",blogDao.getBlog(1003));
	 }
	}


