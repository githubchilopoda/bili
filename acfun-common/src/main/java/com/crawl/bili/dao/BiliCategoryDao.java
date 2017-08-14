package com.crawl.bili.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 *  数据库操作接口
 * 
 */
public interface BiliCategoryDao<T,P> extends BaseMapper<T,P> {

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

	 public List<T> getCategoryList(@Param("top")Boolean top);
}
