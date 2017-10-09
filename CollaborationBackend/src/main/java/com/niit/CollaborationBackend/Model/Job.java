package com.niit.CollaborationBackend.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Job 
{
	@Id
	private int Job_Id;
	private String JobProfile,JobDesc,Qualification,Job_Status;
	private Date PostDate;
	public int getJob_Id() {
		return Job_Id;
	}
	public void setJob_Id(int job_Id) {
		Job_Id = job_Id;
	}
	public String getJobProfile() {
		return JobProfile;
	}
	public void setJobProfile(String jobProfile) {
		JobProfile = jobProfile;
	}
	public String getJobDesc() {
		return JobDesc;
	}
	public void setJobDesc(String jobDesc) {
		JobDesc = jobDesc;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getJob_Status() {
		return Job_Status;
	}
	public void setJob_Status(String job_Status) {
		Job_Status = job_Status;
	}
	public Date getPostDate() {
		return PostDate;
	}
	public void setPostDate(Date postDate) {
		PostDate = postDate;
	}
	

}
