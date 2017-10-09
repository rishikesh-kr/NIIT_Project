package com.niit.CollaborationBackend.Test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackend.Dao.UserDao;

import com.niit.CollaborationBackend.Model.User;

import junit.framework.TestCase;

public class UserDaoTestCase extends TestCase
{
static UserDao userDao;

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.niit.CollaborationBackend");
		annotationConfigApplicationContext.refresh();
		userDao=(UserDao)annotationConfigApplicationContext.getBean("userDao"); 
	}

@Test
public void CreateUserTest()
{
	User user=new User();
	user.setUserId(1001);
	user.setUser_Status("NA");
	user.setRole("null");
	user.setIsOnline("Online");
	user.setPassword("indu");
	user.setFirstname("indu");
	user.setLastname("sri");
	user.setEmailID("indu@gmail.com");
	assertTrue("Problem in User Creation",userDao.CreateUser(user));
}
@Test
public void approveUserTest()
{
	User user=new User();
	user.setUserId(1001);
	user.setUser_Status("NA");
	user.setRole("null");
	user.setIsOnline("Online");
	user.setPassword("indu");
	user.setFirstname("indu");
	user.setLastname("sri");
	user.setEmailID("indu@gmail.com");
	assertTrue("Problem in Approving User",userDao.approveUser(user));	
}
@Test
public void getAllApprovedUserTest()
{
	List<User> listUser=userDao.getUser();
	assertTrue("No Approved User",listUser.size()>0);	
}
 @Test
 public void deleteUserTest()
 {
	 assertTrue("Problem in Deleting",userDao.deleteUser(1001));
 }
 
 @Test
 public void getUserByUserId()
 {
	 assertNotNull("Problem getting User",userDao.getUser(1003));
 }

}