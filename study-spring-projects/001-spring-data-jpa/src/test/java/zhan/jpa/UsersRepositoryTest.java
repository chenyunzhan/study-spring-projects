package zhan.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhan.jpa.dao.UsersDao;
import zhan.jpa.pojo.Roles;
import zhan.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UsersRepositoryTest {
	
	
	@Autowired
	private UsersDao usersDao;
	
	@Test
	public void findUser() {
		
		System.err.println(this.usersDao.getClass().getSimpleName());
		
		Users u = this.usersDao.findUserById(1);
		System.out.println(u);
	}
	
	@Test
	public void saveUser() {
		
		Users u = new Users();
		Roles r = new Roles();
		
		u.setRoles(r);
		u.setUserage(99);
		u.setUsername("舅舅");
		
		
		this.usersDao.save(u);
		
		
	}
	
	
	

	
}
