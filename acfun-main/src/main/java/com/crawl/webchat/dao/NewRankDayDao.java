package com.crawl.webchat.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 
 *  数据库操作接口
 * 
 */
public interface NewRankDayDao<T,P> extends BaseDao<T,P> {

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteByPrimaryKey(@Param("rank") Integer rank,@Param("categoryName") String categoryName,@Param("day") java.util.Date day);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public T selectByPrimaryKey(@Param("rank") Integer rank,@Param("categoryName") String categoryName,@Param("day") java.util.Date day);


}
