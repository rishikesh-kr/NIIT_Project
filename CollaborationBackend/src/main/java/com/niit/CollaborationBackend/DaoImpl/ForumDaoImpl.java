package com.niit.CollaborationBackend.DaoImpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackend.Dao.ForumDao;
import com.niit.CollaborationBackend.Model.Forum;

@Repository("forumDao")
@Transactional
public class ForumDaoImpl implements ForumDao
{
@Autowired
SessionFactory sessionFactory;
 
public ForumDaoImpl (SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}

	public boolean CreateForum(Forum forum) 
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public Forum getForum(int Forum_Id) 
	{
		Session session=sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class,Forum_Id);
		session.close();
		return forum;
	}

	
	public List<Forum> getForum() 
	{
		Session session =sessionFactory.openSession();
		Query query=session.createQuery("from Forum where Forum_Status='B'");
		List<Forum> listForum =query.list();
		session.close();
		return listForum;
	}


	public boolean approveForum(Forum forum) 
	{
		try
		{
			forum.setForum_Status("B");
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}


	public boolean editForum(int Forum_Id) 
	{
		Session session=sessionFactory.openSession();
		Forum forum =(Forum)session.get(Forum.class,Forum_Id);
		session.saveOrUpdate(forum);
		session.flush();
		session.close();
		return true;
	}

	
	public boolean deleteForum(int Forum_Id) 
	{
		try
		{
			Session session =sessionFactory.openSession();
			Forum forum=(Forum)session.get(Forum.class,Forum_Id);
			session.delete(forum);
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
