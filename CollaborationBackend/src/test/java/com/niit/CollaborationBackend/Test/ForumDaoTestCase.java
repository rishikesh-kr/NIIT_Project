package com.niit.CollaborationBackend.Test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackend.Dao.ForumDao;
import com.niit.CollaborationBackend.Model.Forum;

import junit.framework.TestCase;

public class ForumDaoTestCase extends TestCase
{
  static ForumDao forumDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit.CollaborationBackend");
		annotationConfigApplicationContext.refresh();
		forumDao=(ForumDao)annotationConfigApplicationContext.getBean("forumDao");
	}
	@Test
	public void CreateForumTest()
	{
		Forum forum=new Forum();
		forum.setForum_Id(101);;
		forum.setForum_Name("Selenium");
		forum.setForum_Content("Selenium is testing tool");
		forum.setForum_Status("Na");
		forum.setForum_UserId(102);
		forum.setCreateDate(new java.util.Date());
		assertTrue("Problem in Forum Creation",forumDao.CreateForum(forum));
	}
	
	@Test
	public void approveForumTest()
	{
		Forum forum=new Forum();
		forum.setForum_Id(101);;
		forum.setForum_Name("Selenium");
		forum.setForum_Content("Selenium is testing tool");
		forum.setForum_Status("Na");
		forum.setForum_UserId(102);
		forum.setCreateDate(new java.util.Date());
		assertTrue("Problem in Approving Forum",forumDao.approveForum(forum));	
		}
	@Test
	public void getAllApprovedForumTest()
	{
		List<Forum> listForum =forumDao.getForum();
		assertTrue("No Approved Forums",listForum.size()>0);	
	}
	 @Test
	 public void deleteForumTest()
	 {
		 assertTrue("Problem in Deleting",forumDao.deleteForum(1001));
	 }
	 
	 @Test
	 public void getForumByForumId()
	 {
		 assertNotNull("Problem getting forum",forumDao.getForum(1003));
	 }
	
	}



