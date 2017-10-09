package com.niit.CollaborationBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackend.Dao.UserDao;

import com.niit.CollaborationBackend.Model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao
{
@Autowired
SessionFactory sessionFactory;

public UserDaoImpl (SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
	
	public boolean CreateUser(User user) 
	{
		try
		{
	     sessionFactory.getCurrentSession().saveOrUpdate(user);
	     return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	
	}

	
	public User getUser(int UserId) 
	{
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,UserId);
		session.close();
		return user;
	}

	
	public List<User> getUser() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User where User_Status='E'");
		List<User> listUser=query.list();
		session.close();
		return listUser;
	}

	public boolean approveUser(User user) 
	{
	try
	{
		user.setUser_Status("E");
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised:"+e);
		return false;
	}
	}

	
	public boolean editUser(int UserId) 
	{
		try
		{
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,UserId);
		session.saveOrUpdate(user);
		session.flush();
		session.close();
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public boolean deleteUser(int UserId) 
	{
		try
		{
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,UserId);
		session.delete(user);
		session.flush();
		session.close();
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

}
