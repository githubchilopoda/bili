package com.crawl.acfun.service;

import com.crawl.acfun.entity.param.AcfunVideoParam;
import com.crawl.acfun.entity.po.AcfunVideo;
import com.crawl.acfun.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface AcfunVideoService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<AcfunVideo> findListByPage(AcfunVideoParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(AcfunVideo bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(AcfunVideo bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(AcfunVideo bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteAcfunVideoByPrimaryKey(Integer id,Integer webId);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public AcfunVideo getAcfunVideoByPrimaryKey(Integer id,Integer webId);

}