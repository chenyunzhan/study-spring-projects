package zhan.jpa.dao;

import zhan.jpa.pojo.Users;

public interface UsersRepository {
	
	public Users findUserById(Integer userId);

}
