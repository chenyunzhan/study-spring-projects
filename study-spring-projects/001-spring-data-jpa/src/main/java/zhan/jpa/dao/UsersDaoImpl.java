package zhan.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import zhan.jpa.pojo.Users;

public class UsersDaoImpl implements UsersRepository {

	
	@PersistenceContext(name="entityManagerFactory")
	private EntityManager em;
	
	
	public Users findUserById(Integer userId) {
		Users u = this.em.find(Users.class, userId);
		return u;
	}

}
