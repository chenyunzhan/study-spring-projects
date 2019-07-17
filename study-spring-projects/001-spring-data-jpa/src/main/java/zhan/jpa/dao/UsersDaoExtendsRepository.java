package zhan.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import zhan.jpa.pojo.Users;

public interface UsersDaoExtendsRepository extends Repository<Users, Integer> {
	
	List<Users> findByUsernameIs(String username);
	
	List<Users> findByUsernameLike(String username);
	
	List<Users> findByUsernameAndUserageGreaterThanEqual(String username, Integer userage);
	
	
	
	@Query(value = "from Users where username = ?1")
	List<Users> queryByUsernameIs(String username);
	
	@Query(value = "select new Users(userid, username, userage) from Users where username = ?1")
	List<Users> queryByUsernameShi(String username);
	
	@Query(value = "from Users where username like :username")
	List<Users> queryByUsernameLike(@Param("username") String username);
	
	@Query(value = "from Users where username = ?1 and userage >= ?2")
	List<Users> queryByUsernameAndUserageGreaterThanEqual(String username, Integer userage);
	
	
	
	
	@Query(value = "select * from tb_users where username = ?", nativeQuery = true)
	List<Users> queryNativeByUsernameIs(String username);
	
	@Query(value = "select * from tb_users where username like ?", nativeQuery = true)
	List<Users> queryNativeByUsernameLike(String username);
	
	@Query(value = "select * from tb_users where username = ? and userage >= ?", nativeQuery = true)
	List<Users> queryNativeByUsernameAndUserageGreaterThanEqual(String username, Integer userage);
	
	
	
	
	

}
