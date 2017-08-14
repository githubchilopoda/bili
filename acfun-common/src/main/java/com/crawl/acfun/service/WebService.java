package com.crawl.acfun.service;

import com.crawl.acfun.entity.param.WebParam;
import com.crawl.acfun.entity.po.Web;
import com.crawl.acfun.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface WebService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<Web> findListByPage(WebParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(Web bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(Web bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(Web bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteWebByPrimaryKey(Integer webId);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public Web getWebByPrimaryKey(Integer webId);

}