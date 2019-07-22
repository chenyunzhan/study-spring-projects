package zhan.jpa;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhan.jpa.dao.UsersDaoExtendsPagingAndSortingRepository;
import zhan.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PagingAndSortingRepositoryTest {
	
	@Autowired
	private UsersDaoExtendsPagingAndSortingRepository usersDao;
	
	@Test
	public void testPage() {
		PageRequest temp = new PageRequest(0, 2);
		Page<Users> page = this.usersDao.findAll(temp);
		
		System.out.println("总数："+page.getTotalElements());
		System.out.println("页数："+page.getTotalPages());
		for(Users user : page.getContent()) {
			System.out.println(user);
		}
	}
	
	
	@Test
	public void testSort() {
		Sort sort = new Sort(Direction.ASC, "userid");
		
		List<Users> list = (List<Users>) this.usersDao.findAll(sort);
		for(Users user : list) {
			System.out.println(user);
		}
	}
	
	
	
	@Test
	public void testSorts() {
		Order o1 = new Order(Direction.ASC, "userage");
		Order o2 = new Order(Direction.ASC, "username");
		Sort sort = new Sort(o1,o2);
		List<Users> list = (List<Users>) this.usersDao.findAll(sort);
		for(Users user : list) {
			System.out.println(user);
		}
	}
}
