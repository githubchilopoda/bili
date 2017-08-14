package com.crawl.bili.service;

import com.crawl.bili.entity.param.BiliVideoParam;
import com.crawl.bili.entity.po.BiliVideo;
import com.crawl.bili.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface BiliVideoService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<BiliVideo> findListByPage(BiliVideoParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(BiliVideo bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(BiliVideo bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(BiliVideo bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteBiliVideoByPrimaryKey(Integer aid);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public BiliVideo getBiliVideoByPrimaryKey(Integer aid);

}