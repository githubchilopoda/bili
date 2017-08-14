package com.crawl.acfun.service;

import com.crawl.acfun.entity.param.UploaderParam;
import com.crawl.acfun.entity.po.Uploader;
import com.crawl.acfun.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface UploaderService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<Uploader> findListByPage(UploaderParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(Uploader bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(Uploader bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(Uploader bean);
}