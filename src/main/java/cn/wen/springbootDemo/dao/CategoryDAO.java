package cn.wen.springbootDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.wen.springbootDemo.domain.Category;
/**
 * 接口CategoryDAO继承了JpaRepository，并且提供泛型<Category,Integer> 
 * 表示这个是针对Category类的DAO,Integer表示主键是Integer类型。
 * JpaRepository 这个父接口，就提供了CRUD, 分页等等一系列的查询了，直接拿来用，都不需要二次开发的了
 * @author YiWen
 *
 */
public interface CategoryDAO extends JpaRepository<Category,Integer>{
	 
}
