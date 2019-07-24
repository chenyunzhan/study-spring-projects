package zhan.jpa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import zhan.jpa.dao.RolesDaoExtendsJpaRepository;
import zhan.jpa.dao.UsersDao;
import zhan.jpa.pojo.Roles;
import zhan.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UsersRepositoryTest {
	
	
	@Autowired
	private UsersDao usersDao;
	
	
	@Autowired
	private RolesDaoExtendsJpaRepository roleDao;
	
	@Transactional
	@Test
	public void findUser() {
		
		System.err.println(this.usersDao.getClass().getSimpleName());
		
		Users u = this.usersDao.findUserById(8);
		
		Roles roles = u.getRoles();
		System.out.println(roles.getUsers());;
		
		System.out.println(u);
	}
	
	@Test
	public void saveUser() {
		
		Roles r = new Roles();
		r.setRoleid(5);
		
		Users u = new Users();
		u.setRoles(r);
		u.setUserage(99);
		u.setUsername("舅舅");
		
		
		Users uu = new Users();
		uu.setRoles(r);
		uu.setUserage(99);
		uu.setUsername("妈妈");
		
		
		
//		Set<Users> users = new HashSet<Users>();
//		users.add(uu);
//		users.add(u);
//		r.setUsers(users);
		
//		this.roleDao.save(r);
		
		
		
		ArrayList<Users> list = new ArrayList<Users>();
		list.add(uu);
		list.add(u);
		
		
		this.usersDao.save(list);
//		this.usersDao.save(uu);
		
		
	}
	
	
	

	
}
