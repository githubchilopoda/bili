package com.crawl.webchat.service;

import com.crawl.webchat.entity.param.PgcWeekRankParam;
import com.crawl.webchat.entity.po.PgcWeekRank;
import com.crawl.webchat.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface PgcWeekRankService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<PgcWeekRank> findListByPage(PgcWeekRankParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(PgcWeekRank bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(PgcWeekRank bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(PgcWeekRank bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deletePgcWeekRankByPrimaryKey(Integer rank,Integer categoryId,java.util.Date dayBegin);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public PgcWeekRank getPgcWeekRankByPrimaryKey(Integer rank,Integer categoryId,java.util.Date dayBegin);

}