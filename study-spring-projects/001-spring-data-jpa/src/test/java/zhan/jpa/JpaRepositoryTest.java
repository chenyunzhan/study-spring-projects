package zhan.jpa;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhan.jpa.dao.UsersDaoExtendsJpaRepository;
import zhan.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaRepositoryTest {
	
	@Autowired
	private UsersDaoExtendsJpaRepository usersDao;
	
	@Test
	public void saveUser() {
		
		List<Users> list = this.usersDao.findAll();
		for(Users user : list) {
			System.out.println(user);
		}
	}
	
	

	
}
