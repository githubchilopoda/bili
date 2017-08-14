package com.crawl.bili.service;

import com.crawl.bili.entity.param.BiliUserParam;
import com.crawl.bili.entity.po.BiliUser;
import com.crawl.bili.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface BiliUserService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<BiliUser> findListByPage(BiliUserParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(BiliUser bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(BiliUser bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(BiliUser bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteBiliUserByPrimaryKey(Integer mid);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public BiliUser getBiliUserByPrimaryKey(Integer mid);

}