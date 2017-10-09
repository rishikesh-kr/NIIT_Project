package com.niit.CollaborationBackend.Dao;

import java.util.List;

import com.niit.CollaborationBackend.Model.Blog;

public interface BlogDao 
{
public boolean CreateBlog(Blog blog);
public Blog getBlog(int Blog_Id);
public List<Blog> getBlog();
public boolean approveBlog(Blog blog);
public boolean editBlog(int Blog_Id);
public boolean deleteBlog(int Blog_Id);
}
