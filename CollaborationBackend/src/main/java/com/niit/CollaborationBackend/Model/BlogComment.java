package com.niit.CollaborationBackend.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BlogComment
{
@Id
private int Blogc_Id;
private int Bc_Blog_Id;
private String Blogc_Comment;
private Date CommentDate;
private int Blogc_UserId;
private String Blogc_Username;
public int getBlogc_Id() {
	return Blogc_Id;
}
public void setBlogc_Id(int blogc_Id) {
	Blogc_Id = blogc_Id;
}
public int getBc_Blog_Id() {
	return Bc_Blog_Id;
}
public void setBc_Blog_Id(int bc_Blog_Id) {
	Bc_Blog_Id = bc_Blog_Id;
}
public String getBlogc_Comment() {
	return Blogc_Comment;
}
public void setBlogc_Comment(String blogc_Comment) {
	Blogc_Comment = blogc_Comment;
}
public Date getCommentDate() {
	return CommentDate;
}
public void setCommentDate(Date commentDate) {
	CommentDate = commentDate;
}
public int getBlogc_UserId() {
	return Blogc_UserId;
}
public void setBlogc_UserId(int blogc_UserId) {
	Blogc_UserId = blogc_UserId;
}
public String getBlogc_Username() {
	return Blogc_Username;
}
public void setBlogc_Username(String blogc_Username) {
	Blogc_Username = blogc_Username;
}

}
