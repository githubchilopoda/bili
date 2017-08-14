package com.crawl.acfun.service;

import com.crawl.acfun.entity.param.RankVideoParam;
import com.crawl.acfun.entity.po.RankVideo;
import com.crawl.acfun.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface RankVideoService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<RankVideo> findListByPage(RankVideoParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(RankVideo bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(RankVideo bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(RankVideo bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteRankVideoByPrimaryKey(Integer id,Integer webId);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public RankVideo getRankVideoByPrimaryKey(Integer id,Integer webId);

}