package zhan.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import zhan.jpa.pojo.Roles;

public interface RolesDaoExtendsJpaRepository extends JpaRepository<Roles,Integer> {
	


}
