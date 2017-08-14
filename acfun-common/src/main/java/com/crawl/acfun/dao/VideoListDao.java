package com.crawl.acfun.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 
 *  数据库操作接口
 * 
 */
public interface VideoListDao<T,P> extends BaseDao<T,P> {

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


}
