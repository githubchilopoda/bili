package com.crawl.webchat.service;

import com.crawl.webchat.entity.param.NewRankDayParam;
import com.crawl.webchat.entity.po.NewRankDay;
import com.crawl.webchat.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface NewRankDayService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<NewRankDay> findListByPage(NewRankDayParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(NewRankDay bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(NewRankDay bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(NewRankDay bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteNewRankDayByPrimaryKey(Integer rank,String categoryName,java.util.Date day);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public NewRankDay getNewRankDayByPrimaryKey(Integer rank,String categoryName,java.util.Date day);

}