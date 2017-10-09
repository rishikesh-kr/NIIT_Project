package com.niit.CollaborationBackend.DaoImpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CollaborationBackend.Dao.FriendDao;
import com.niit.CollaborationBackend.Model.Friend;

@Repository("friendDao")
@Transactional
public class FriendDaoImpl implements FriendDao
{
@Autowired
SessionFactory sessionFactory;

public FriendDaoImpl (SessionFactory sessionFactory)
{
	this.sessionFactory=sessionFactory;
}
	
	public boolean CreateFriend(Friend friend)
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public Friend getFriend(int Friend_Id)
	{
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class,Friend_Id);
		session.close();
		return friend;
	}

	
	public List<Friend> getFriend()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where Friend_Status='C'");
		List<Friend> listFriend=query.list();
		session.close();
		return listFriend;
	}

	
	public boolean approveFriend(Friend friend) 
	{
		try
		{
			friend.setFriend_Status("C");
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
			return false;
		}
	}

	
	public boolean editFriend(int Friend_Id) 
	{
		try
		{
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class,Friend_Id);
		session.saveOrUpdate(friend);
		session.flush();
		session.close();
		return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

	
	public boolean deleteFriend(int Friend_Id)
	{
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=(Friend)session.get(Friend.class,Friend_Id);
			session.delete(friend);
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}

}
