package zhan.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import zhan.jpa.pojo.Course;

public interface CourseExtendsJpaSpecificationExecutor extends  JpaSpecificationExecutor<Course>,JpaRepository<Course,Integer> {


}
