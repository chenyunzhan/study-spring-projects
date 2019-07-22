package zhan.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhan.jpa.dao.UsersDaoExtendsJpaSpecificationExecutor;
import zhan.jpa.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JpaSpecificationExecutorTest {
	
	@Autowired
	private UsersDaoExtendsJpaSpecificationExecutor usersDao;
	
	@Test
	public void findUser() {
		
		Specification<Users> spec = new Specification<Users>() {

			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("username"), "陈云展");
			}
		};
		
		List<Users> list = this.usersDao.findAll(spec );
		for(Users u : list) {
			System.out.println(u);
		}

	}
	
	@Test
	public void findUserWithAnd() {
		
		Specification<Users> spec = new Specification<Users>() {
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.or(cb.equal(root.get("username"), "陈云展"), cb.equal(root.get("userage"), 16));
			}
		};
		
		List<Users> list = this.usersDao.findAll(spec );
		for(Users u : list) {
			System.out.println(u);
		}

	}
	
	
	@Test
	public void findUserWithLike() {
		
		Specification<Users> spec = new Specification<Users>() {
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get("username").as(String.class), "陈%");
			}
		};
		PageRequest req = new PageRequest(0, 2);
		Page<Users> page = this.usersDao.findAll(spec, req);
		System.out.println("总数："+page.getTotalElements());
		System.out.println("页数："+page.getTotalPages());
		for(Users u : page.getContent()) {
			System.out.println(u);
		}

	}	

	@Test
	public void findUserWithSort() {
		
		Specification<Users> spec = new Specification<Users>() {
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get("username").as(String.class), "陈%");
			}
		};
		
		Sort s = new Sort(Direction.ASC, "userid");
		List<Users> list = this.usersDao.findAll(spec, s);
		for(Users u : list) {
			System.out.println(u);
		}

	}		
	
	

	@Test
	public void findUserWithSortAndPage() {
		
		Specification<Users> spec = new Specification<Users>() {
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.like(root.get("username").as(String.class), "陈%");
			}
		};
		
		Sort s = new Sort(Direction.ASC, "userid");
		PageRequest req = new PageRequest(0, 2, s);

		Page<Users> page = this.usersDao.findAll(spec, req);
		System.out.println("总数："+page.getTotalElements());
		System.out.println("页数："+page.getTotalPages());
		for(Users u : page.getContent()) {
			System.out.println(u);
		}

	}	
	
	
	
}
