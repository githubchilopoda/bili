package com.crawl.bili.service;

import com.crawl.bili.entity.param.BiliFunParam;
import com.crawl.bili.entity.po.BiliFun;
import com.crawl.bili.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface BiliFunService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<BiliFun> findListByPage(BiliFunParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(BiliFun bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(BiliFun bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(BiliFun bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteBiliFunByPrimaryKey(Integer aid);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public BiliFun getBiliFunByPrimaryKey(Integer aid);

}