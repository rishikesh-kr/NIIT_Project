package com.niit.CollaborationBackend.Dao;

import java.util.List;

import com.niit.CollaborationBackend.Model.Job;

public interface JobDao 
{
public boolean CreateJob(Job job);
public Job getJob(int Job_Id);
public List<Job> getJob();
public boolean approveJob(Job job);
public boolean editJob(int Job_Id);
public boolean deleteJob(int Job_Id);
}
