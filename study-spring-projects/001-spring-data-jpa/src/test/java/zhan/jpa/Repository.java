package zhan.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhan.jpa.dao.UsersDaoExtendsRepository;
import zhan.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Repository {
	
	@Autowired
	private UsersDaoExtendsRepository usersDao;
	
	@Test
	public void testFindByUsernameIs() {
		List<Users> users = new ArrayList<Users>();
		users = this.usersDao.findByUsernameIs("黄雅莉");
		users = this.usersDao.findByUsernameLike("黄雅莉");
		users = this.usersDao.findByUsernameAndUserageGreaterThanEqual("黄雅莉", 20);
		
		users = this.usersDao.queryByUsernameIs("黄雅莉");
		users = this.usersDao.queryByUsernameLike("黄雅莉");
		users = this.usersDao.queryByUsernameShi("黄雅莉");
		users = this.usersDao.queryByUsernameAndUserageGreaterThanEqual("黄雅莉", 20);
		
		users = this.usersDao.queryNativeByUsernameIs("黄雅莉");
		users = this.usersDao.queryNativeByUsernameLike("黄雅莉");
		users = this.usersDao.queryNativeByUsernameAndUserageGreaterThanEqual("黄雅莉", 20);
		
		for(Users u : users) {
			System.out.println(u);
		}
		
		
		System.err.println(this.usersDao);
		System.err.println(this.usersDao.getClass().getSimpleName());
	}
	
}
