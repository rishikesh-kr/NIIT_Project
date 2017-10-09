package com.niit.CollaborationBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackend.Dao.JobDao;
import com.niit.CollaborationBackend.Model.Job;

@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao
{
@Autowired
SessionFactory sessionFactory;

public JobDaoImpl(SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}

	
	public boolean CreateJob(Job job) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		
	}

	
	public Job getJob(int Job_Id)
	{
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class,Job_Id);
		session.close();
		return job;
	}

	
	public List<Job> getJob() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Job where Job_Status='D'");
		List<Job> listJob=query.list();
		session.close();
		return listJob;
	}

	
	public boolean approveJob(Job job) 
	{
		try
		{
		job.setJob_Status("D");
		sessionFactory.getCurrentSession().saveOrUpdate(job);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public boolean editJob(int Job_Id) 
	{
		try
		{
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class,Job_Id);
		session.saveOrUpdate(job);
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

	
	public boolean deleteJob(int Job_Id)
	{
		try
		{
		Session session=sessionFactory.openSession();
		Job job=(Job)session.get(Job.class,Job_Id);
		session.delete(job);
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
