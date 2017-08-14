package com.crawl.webchat.service;

import com.crawl.webchat.entity.param.WeiboWeekRankParam;
import com.crawl.webchat.entity.po.WeiboWeekRank;
import com.crawl.webchat.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface WeiboWeekRankService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<WeiboWeekRank> findListByPage(WeiboWeekRankParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(WeiboWeekRank bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(WeiboWeekRank bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(WeiboWeekRank bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteWeiboWeekRankByPrimaryKey(Integer rank,Integer type,java.util.Date dayBegin);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public WeiboWeekRank getWeiboWeekRankByPrimaryKey(Integer rank,Integer type,java.util.Date dayBegin);

}