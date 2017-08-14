package com.crawl.acfun.service;

import com.crawl.acfun.entity.param.CategoryParam;
import com.crawl.acfun.entity.po.Category;
import com.crawl.acfun.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface CategoryService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<Category> findListByPage(CategoryParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(Category bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(Category bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(Category bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteCategoryByPrimaryKey(Integer id);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public Category getCategoryByPrimaryKey(Integer id);

}