package com.niit.CollaborationBackend.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Forum 
{
@Id
private int Forum_Id;
private String Forum_Name;
private String Forum_Content;
private String Forum_Status;
private int Forum_UserId;
private Date CreateDate;
public int getForum_Id() {
	return Forum_Id;
}
public void setForum_Id(int forum_Id) {
	Forum_Id = forum_Id;
}
public String getForum_Name() {
	return Forum_Name;
}
public void setForum_Name(String forum_Name) {
	Forum_Name = forum_Name;
}
public String getForum_Content() {
	return Forum_Content;
}
public void setForum_Content(String forum_Content) {
	Forum_Content = forum_Content;
}
public String getForum_Status() {
	return Forum_Status;
}
public void setForum_Status(String forum_Status) {
	Forum_Status = forum_Status;
}
public int getForum_UserId() {
	return Forum_UserId;
}
public void setForum_UserId(int forum_UserId) {
	Forum_UserId = forum_UserId;
}
public Date getCreateDate() {
	return CreateDate;
}
public void setCreateDate(Date createDate) {
	CreateDate = createDate;
}


}
