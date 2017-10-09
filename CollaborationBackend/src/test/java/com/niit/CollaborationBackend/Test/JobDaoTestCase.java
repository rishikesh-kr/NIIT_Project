package com.niit.CollaborationBackend.Test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.CollaborationBackend.Dao.JobDao;
import com.niit.CollaborationBackend.Model.Job;

import junit.framework.TestCase;

public class JobDaoTestCase extends TestCase
{
static JobDao jobDao;
@BeforeClass
public static void initialize()
{
	AnnotationConfigApplicationContext annotationConfigApplicationContext=new AnnotationConfigApplicationContext();
	annotationConfigApplicationContext.scan("com.niit.CollaborationBackend");
	annotationConfigApplicationContext.refresh();
	jobDao=(JobDao)annotationConfigApplicationContext.getBean("jobDao");
}

@Test
public void CreateJobTest()
{
	Job job=new Job();
	job.setJob_Id(1001);
	job.setJob_Status("NA");
	job.setJobDesc("It is based on java Programming");
	job.setJobProfile("Developer");
	job.setPostDate(new java.util.Date());
	assertTrue("Problem in Job Creation",jobDao.CreateJob(job));
}
@Test
public void approveJobTest()
{
	Job job=new Job();
	job.setJob_Id(1001);
	job.setJob_Status("NA");
	job.setJobDesc("It is based on java Programming");
	job.setJobProfile("Developer");
	job.setPostDate(new java.util.Date());
	job.setQualification("BE");
	assertTrue("Problem in Approving Job",jobDao.CreateJob(job));
}
@Test
public void getAllApprovedJobTest()
{
	List<Job> listJob=jobDao.getJob();
	assertTrue("No Approved Job",listJob.size()>0);
}
@Test
public void deleteJobTest()
{
	assertTrue("Problem in Deleting",jobDao.deleteJob(1001));
}
@Test
public void getJobByJobId()
{
	assertNotNull("Problem getting job",jobDao.getJob(1003));
}
}





