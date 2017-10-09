package com.niit.CollaborationBackend.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Friend 
{
@Id
private int Friend_UserId;
private int Friend_Id;
private String Friend_Status;

public int getFriend_UserId() {
	return Friend_UserId;
}
public void setFriend_UserId(int friend_UserId) {
	Friend_UserId = friend_UserId;
}
public int getFriend_Id() {
	return Friend_Id;
}
public void setFriend_Id(int friend_Id) {
	Friend_Id = friend_Id;
}
public String getFriend_Status() {
	return Friend_Status;
}
public void setFriend_Status(String friend_Status) {
	Friend_Status = friend_Status;
}

}
