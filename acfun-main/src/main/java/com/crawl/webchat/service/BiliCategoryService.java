package com.crawl.webchat.service;

import com.crawl.webchat.entity.param.BiliCategoryParam;
import com.crawl.webchat.entity.po.BiliCategory;
import com.crawl.webchat.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface BiliCategoryService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<BiliCategory> findListByPage(BiliCategoryParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(BiliCategory bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(BiliCategory bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(BiliCategory bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteBiliCategoryByPrimaryKey(Integer id);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public BiliCategory getBiliCategoryByPrimaryKey(Integer id);

}