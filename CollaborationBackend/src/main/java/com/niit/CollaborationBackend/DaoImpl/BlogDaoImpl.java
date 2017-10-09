package com.niit.CollaborationBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackend.Dao.BlogDao;
import com.niit.CollaborationBackend.Model.Blog;

@Repository("blogDao")
@EnableTransactionManagement
@Transactional
public class BlogDaoImpl implements BlogDao
{
   @Autowired
   SessionFactory sessionFactory;
   
   public BlogDaoImpl(SessionFactory sessionFactory)
   {
	   this.sessionFactory=sessionFactory;
   }
	
   
	public boolean CreateBlog(Blog blog) 
    {
	try
	{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
	}
	catch(Exception e)
	{
		System.out.println("Exception Arised:"+e);
		return false;
	}
	}

	
	public Blog getBlog(int Blog_Id) 
	{
		Session session=sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class,Blog_Id);
		session.close();
		return blog;
	}

	public List<Blog> getBlog() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Blog where Blog_Status='A'");
		List<Blog> listBlog=query.list();
		session.close();
		return listBlog;
	}

	
	public boolean approveBlog(Blog blog)
	{
	try
	{
		blog.setBlog_Status("A");
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
	}
	catch (Exception e)
	{
		System.out.println("Exception Arised:"+e);
		return false;
	}
	}

	
	public boolean editBlog(int Blog_Id)
	{
		try
		{
			Session session =sessionFactory.openSession();
			Blog blog=(Blog)session.get(Blog.class,Blog_Id);
			session.saveOrUpdate(Blog_Id);
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

	
	public boolean deleteBlog(int Blog_Id) 
	{
		try
		{
			Session session =sessionFactory.openSession();
			Blog blog=(Blog)session.get(Blog.class,Blog_Id);
			session.delete(blog);
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
