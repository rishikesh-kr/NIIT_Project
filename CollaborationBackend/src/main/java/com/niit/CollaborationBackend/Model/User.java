package com.niit.CollaborationBackend.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User 
{
@Id
private int UserId;
private String Firstname,Lastname,Password,EmailID,Role,User_Status,isOnline;
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public String getFirstname() {
	return Firstname;
}
public void setFirstname(String firstname) {
	Firstname = firstname;
}
public String getLastname() {
	return Lastname;
}
public void setLastname(String lastname) {
	Lastname = lastname;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getEmailID() {
	return EmailID;
}
public void setEmailID(String emailID) {
	EmailID = emailID;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}
public String getUser_Status() {
	return User_Status;
}
public void setUser_Status(String user_Status) {
	User_Status = user_Status;
}
public String getIsOnline() {
	return isOnline;
}
public void setIsOnline(String isOnline) {
	this.isOnline = isOnline;
}

}
