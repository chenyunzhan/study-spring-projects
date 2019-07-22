package zhan.jpa.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import zhan.jpa.pojo.Users;

public interface UsersDaoExtendsPagingAndSortingRepository extends PagingAndSortingRepository<Users,Integer> {
	


}
