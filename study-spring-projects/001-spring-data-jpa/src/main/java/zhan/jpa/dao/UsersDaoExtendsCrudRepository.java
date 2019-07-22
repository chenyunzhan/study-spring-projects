package zhan.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import zhan.jpa.pojo.Users;

public interface UsersDaoExtendsCrudRepository extends CrudRepository<Users,Integer> {
	


}
