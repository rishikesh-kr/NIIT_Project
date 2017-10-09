package com.niit.CollaborationBackend.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ForumComment 
{
@Id
private int Fc_Id;
private int Fc_Forum_Id;
private int Forumc_Comment;
private int Forumc_UserId;
private String Forumc_Username;
private Date CommentDate;
public int getFc_Id() {
	return Fc_Id;
}
public void setFc_Id(int fc_Id) {
	Fc_Id = fc_Id;
}
public int getFc_Forum_Id() {
	return Fc_Forum_Id;
}
public void setFc_Forum_Id(int fc_Forum_Id) {
	Fc_Forum_Id = fc_Forum_Id;
}
public int getForumc_Comment() {
	return Forumc_Comment;
}
public void setForumc_Comment(int forumc_Comment) {
	Forumc_Comment = forumc_Comment;
}
public int getForumc_UserId() {
	return Forumc_UserId;
}
public void setForumc_UserId(int forumc_UserId) {
	Forumc_UserId = forumc_UserId;
}
public String getForumc_Username() {
	return Forumc_Username;
}
public void setForumc_Username(String forumc_Username) {
	Forumc_Username = forumc_Username;
}
public Date getCommentDate() {
	return CommentDate;
}
public void setCommentDate(Date commentDate) {
	CommentDate = commentDate;
}

}
