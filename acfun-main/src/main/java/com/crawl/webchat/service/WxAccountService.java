package com.crawl.webchat.service;

import com.crawl.webchat.entity.param.WxAccountParam;
import com.crawl.webchat.entity.po.WxAccount;
import com.crawl.webchat.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface WxAccountService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<WxAccount> findListByPage(WxAccountParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(WxAccount bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(WxAccount bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(WxAccount bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteWxAccountByPrimaryKey(String account);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public WxAccount getWxAccountByPrimaryKey(String account);

}