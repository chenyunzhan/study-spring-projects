package zhan.jpa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import zhan.jpa.dao.UsersDaoExtendsCrudRepository;
import zhan.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CrudRepositoryTest {
	
	@Autowired
	private UsersDaoExtendsCrudRepository usersDao;
	
	@Test
	public void saveUser() {
		
		Users u = new Users();
		u.setUserid(8);
		u.setUserage(16);
		u.setUsername("陈云展");
		this.usersDao.save(u);

		System.err.println(this.usersDao);
		System.err.println(this.usersDao.getClass().getSimpleName());
	}
	
	
	@Test
	public void saveUsers() {
		
		Users u = new Users();
		u.setUserage(1);
		u.setUsername("陈云展");
		
		Users u2 = new Users();
		u2.setUserage(2);
		u2.setUsername("陈云展2");
		
		
		List<Users> users = new ArrayList<Users>();
		users.add(u);
		users.add(u2);
		
		this.usersDao.save(users);

		System.err.println(this.usersDao);
		System.err.println(this.usersDao.getClass().getSimpleName());
	}
	
	
	@Test
	public void findOne() {
		Users u = this.usersDao.findOne(7);
		System.out.println(u);
	}
	
	
	@Test
	public void findAll() {
		Iterable<Users> us = this.usersDao.findAll();
		for (Iterator<Users> iterator = us.iterator(); iterator.hasNext();) {
			Users u = (Users) iterator.next();
			System.out.println(u);
		}
	}
	
	@Test
	public void deleteById() {
		this.usersDao.delete(7);
	}
	
	
	@Test
	public void updateByUser() {
		Users u = this.usersDao.findOne(8);
		u.setUsername("新的名字");
		this.usersDao.save(u);
	}
	
	
	@Test
	@Transactional
	@Rollback(false)
	public void updateUser() {
		Users u = this.usersDao.findOne(8);
		u.setUsername("新的名字6");
	}
	
}
