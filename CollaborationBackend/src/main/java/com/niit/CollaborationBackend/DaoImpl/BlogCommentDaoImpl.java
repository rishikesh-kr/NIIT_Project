package com.niit.CollaborationBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackend.Dao.BlogCommentDao;
import com.niit.CollaborationBackend.Model.BlogComment;

@Repository("blogCommentDao")
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao
{
@Autowired
SessionFactory sessionFactory;
 public BlogCommentDaoImpl (SessionFactory sessionFactory)
 {
	 this.sessionFactory=sessionFactory;
 }
	public boolean CreateBlogComment(BlogComment blogComment) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public BlogComment getBlogComment(int Blogc_Id) 
	{
		Session session=sessionFactory.openSession();
		BlogComment blogComment=(BlogComment)session.get(BlogComment.class,Blogc_Id);
		session.close();
		return blogComment;
		
	}

	
	public List<BlogComment> getBlogComment()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where Blogc_Id='101'");
		List<BlogComment> listBlogComment=query.list();
		session.close();
		return listBlogComment;
	}

	
	public boolean approveBlogComment(BlogComment blogComment) 
	{
		try
		{
			blogComment.setBlogc_Id(101);
			sessionFactory.getCurrentSession().saveOrUpdate(blogComment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public boolean editBlogComment(int Blogc_Id) 
	{
		try
		{
		Session session=sessionFactory.openSession();
		BlogComment blogComment=(BlogComment)session.get(BlogComment.class,Blogc_Id);
		session.saveOrUpdate(blogComment);
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

	
	public boolean deleteBlogComment(int Blogc_Id) 
	{
		try
		{
			Session session =sessionFactory.openSession();
			BlogComment blogComment=(BlogComment)session.get(BlogComment.class,Blogc_Id);
			session.delete(blogComment);
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
