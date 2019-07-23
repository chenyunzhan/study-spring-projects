package zhan.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import zhan.jpa.pojo.Users;

public interface UsersDao extends JpaRepository<Users, Integer>, UsersRepository {

}
