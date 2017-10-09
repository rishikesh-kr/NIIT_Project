package com.niit.CollaborationBackend.Test;



import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackend.Dao.FriendDao;
import com.niit.CollaborationBackend.Model.Friend;

import junit.framework.TestCase;

public class FriendDaoTestCase extends TestCase
{
 static FriendDao friendDao;
 
 @BeforeClass
 public static void initialize()
 {
 AnnotationConfigApplicationContext  annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
 annotationConfigApplicationContext.scan("com.niit.CollaborationBackend");
 annotationConfigApplicationContext.refresh();
 friendDao=(FriendDao)annotationConfigApplicationContext.getBean("friendDao"); 
 }
	@Test
	public void CreateFriendTest()
	{
		Friend friend=new Friend();
		friend.setFriend_Id(1001);
		friend.setFriend_Status("NA");
		friend.setFriend_UserId(1002);
		assertTrue("Problem in Friend Creation",friendDao.CreateFriend(friend));
	}
	@Test
	public void approveFriendTest()
	{
		Friend friend=new Friend();
		friend.setFriend_Id(1001);
		friend.setFriend_Status("NA");
		friend.setFriend_UserId(1002);
		assertTrue("Problem in Approving Friend",friendDao.approveFriend(friend));
		
	}
	@Test
	public void getAllApprovedFriendTest()
	{
		List<Friend> listFriend=friendDao.getFriend();
		assertTrue("No Approved Friend",listFriend.size()>0);	
	}
	 @Test
	 public void deleteFriendTest()
	 {
		 assertTrue("Problem in Deleting",friendDao.deleteFriend(1001));
	 }
	 
	 @Test
	 public void getFriendByFriendId()
	 {
		 assertNotNull("Problem getting Friend",friendDao.getFriend(1003));
	 }
	}

