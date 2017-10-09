package com.niit.CollaborationBackend.Dao;

import java.util.List;

import com.niit.CollaborationBackend.Model.BlogComment;

public interface BlogCommentDao 
{
	public boolean CreateBlogComment(BlogComment blogComment);
	public BlogComment getBlogComment(int Blogc_Id);
	public List<BlogComment> getBlogComment ();
	public boolean approveBlogComment(BlogComment blogComment);
	public boolean editBlogComment(int Blogc_Id);
	public boolean deleteBlogComment(int Blogc_Id);
	

}
