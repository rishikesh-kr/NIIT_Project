package com.niit.CollaborationBackend.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class Blog 
{
	@Id
	private int Blog_Id;
	private String Blog_Name,Blog_Content,Blog_Status,Blog_Username;
	private int likes;
	private Date createDate;
	public int getBlog_Id() {
		return Blog_Id;
	}
	public void setBlog_Id(int blog_Id) {
		Blog_Id = blog_Id;
	}
	public String getBlog_Name() {
		return Blog_Name;
	}
	public void setBlog_Name(String blog_Name) {
		Blog_Name = blog_Name;
	}
	public String getBlog_Content() {
		return Blog_Content;
	}
	public void setBlog_Content(String blog_Content) {
		Blog_Content = blog_Content;
	}
	public String getBlog_Status() {
		return Blog_Status;
	}
	public void setBlog_Status(String blog_Status) {
		Blog_Status = blog_Status;
	}
	public String getBlog_Username() {
		return Blog_Username;
	}
	public void setBlog_Username(String blog_Username) {
		Blog_Username = blog_Username;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
