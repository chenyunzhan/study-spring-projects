package zhan.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zhan.jpa.pojo.Users;

public interface UsersDaoExtendsJpaRepository extends JpaRepository<Users,Integer> {
	


}
