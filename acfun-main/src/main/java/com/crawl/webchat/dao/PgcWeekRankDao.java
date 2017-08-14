package com.crawl.webchat.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 
 *  数据库操作接口
 * 
 */
public interface PgcWeekRankDao<T,P> extends BaseDao<T,P> {

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteByPrimaryKey(@Param("rank") Integer rank,@Param("categoryId") Integer categoryId,@Param("dayBegin") java.util.Date dayBegin);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public T selectByPrimaryKey(@Param("rank") Integer rank,@Param("categoryId") Integer categoryId,@Param("dayBegin") java.util.Date dayBegin);


}
