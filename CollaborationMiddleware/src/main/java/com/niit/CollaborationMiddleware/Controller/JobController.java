package com.niit.CollaborationMiddleware.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CollaborationBackend.Dao.JobDao;
import com.niit.CollaborationBackend.Model.Job;

@RestController
public class JobController 
{
	@Autowired
	JobDao jobDao;
	
	@GetMapping(value="/getAllJob")
	public ResponseEntity<ArrayList<Job>> getAllJob()
	{
	 ArrayList<Job> listJob=new ArrayList<Job>();
	 listJob=(ArrayList<Job>)jobDao.getJob();
	 return new ResponseEntity<ArrayList<Job>>(listJob,HttpStatus.OK);
	}

	@PostMapping(value="/CreateJob")
	public ResponseEntity<String> createJob(@RequestBody Job job)
	{
		job.setJob_Status("NA");
		if(jobDao.CreateJob(job))
		{
			return new ResponseEntity<String>("Job Created",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in Job Creation",HttpStatus.NOT_ACCEPTABLE);
		}
	}
		
		@GetMapping(value="/approveJob/{Job_Id}")
		public ResponseEntity<String> approveJob(@PathVariable("Job_Id")int Job_Id)
		{
			Job job=jobDao.getJob(Job_Id);
			if(jobDao.approveJob(job))
			{
				return new ResponseEntity<String>("Job Approved",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Problem in Job Approval",HttpStatus.NOT_ACCEPTABLE);
			}
			
		}
		
		@GetMapping(value="/deleteJob/{Job_Id}")
		public ResponseEntity<String> deleteJob(@PathVariable("Job_Id")int Job_Id)
		{
			if(jobDao.deleteJob(Job_Id))
			{
				return new ResponseEntity<String>("Job Deleted",HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<String>("Problem in Job Deletion",HttpStatus.NOT_ACCEPTABLE);
			}
		}
		
		@GetMapping(value="/test")
		public ResponseEntity<String> testMethod()
		{
			return new ResponseEntity<String>("Test RestController",HttpStatus.OK);
		}
}
