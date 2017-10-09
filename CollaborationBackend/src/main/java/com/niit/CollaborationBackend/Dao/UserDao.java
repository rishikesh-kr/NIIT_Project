package com.niit.CollaborationBackend.Dao;

import java.util.List;

import com.niit.CollaborationBackend.Model.User;

public interface UserDao 
{
public boolean CreateUser(User user);
public User getUser(int UserId);
public List<User> getUser();
public boolean approveUser(User user);
public boolean editUser(int UserId);
public boolean deleteUser(int UserId);
}
