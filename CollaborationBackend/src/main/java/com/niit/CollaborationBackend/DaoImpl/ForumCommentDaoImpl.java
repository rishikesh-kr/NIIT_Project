package com.niit.CollaborationBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackend.Dao.ForumCommentDao;

import com.niit.CollaborationBackend.Model.ForumComment;

@Repository("forumCommentDao")
@Transactional
public class ForumCommentDaoImpl implements ForumCommentDao
{
@Autowired
SessionFactory sessionFactory;
 
public ForumCommentDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}


public boolean CreateForumComment(ForumComment forumComment) 
{
	try
	{
	sessionFactory.getCurrentSession().saveOrUpdate(forumComment);
	return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised:"+e);
		return false;
	}
	
}

public ForumComment getForumComment(int Fc_Id) {
	Session session=sessionFactory.openSession();
	ForumComment forumComment=(ForumComment)session.get(ForumComment.class, Fc_Id);
	session.close();
	return forumComment;
}


public List<ForumComment> getForumComment() 
{
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from ForumComment where Fc_Id='101'");
	List<ForumComment> listForumComment=query.list();
	session.close();
	return listForumComment;	
}


public boolean approveForumComment(ForumComment forumComment) 
{
	try
	{
		forumComment.setFc_Id(101);
		sessionFactory.getCurrentSession().saveOrUpdate(forumComment);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised:"+e);
		return false;
	}
}


public boolean editForumComment(int Fc_Id) 
{
	try
	{
	Session session=sessionFactory.openSession();
	ForumComment forumComment=(ForumComment)session.get(ForumComment.class,Fc_Id);
	session.saveOrUpdate(forumComment);
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


public boolean deleteForumComment(int Fc_Id)
{
	try
	{
	Session session=sessionFactory.openSession();
	ForumComment forumComment=(ForumComment)session.get(ForumComment.class,Fc_Id);
	session.delete(forumComment);
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