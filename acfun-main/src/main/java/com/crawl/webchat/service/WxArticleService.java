package com.crawl.webchat.service;

import com.crawl.webchat.entity.param.WxArticleParam;
import com.crawl.webchat.entity.po.WxArticle;
import com.crawl.webchat.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface WxArticleService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<WxArticle> findListByPage(WxArticleParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(WxArticle bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(WxArticle bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(WxArticle bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteWxArticleByPrimaryKey(Long mid);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public WxArticle getWxArticleByPrimaryKey(Long mid);

}