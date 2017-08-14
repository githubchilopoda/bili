package com.crawl.acfun.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 *  数据库操作接口
 * 
 */
public interface CategoryDao<T,P> extends BaseDao<T,P> {

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteByPrimaryKey(@Param("id") Integer id);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public T selectByPrimaryKey(@Param("id") Integer id);
	 
	 /**
	 * 
	 * @param top:  如果为null， 读取所有的， 如果为true， 读取顶级的， 如果为false， 读取子类目
	 * 
	 */
	 public List<T> getCategoryList(@Param("top")Boolean top);


}
