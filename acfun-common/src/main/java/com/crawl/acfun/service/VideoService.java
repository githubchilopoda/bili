package com.crawl.acfun.service;

import com.crawl.acfun.entity.param.VideoParam;
import com.crawl.acfun.entity.po.Video;
import com.crawl.acfun.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface VideoService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<Video> findListByPage(VideoParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(Video bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(Video bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(Video bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteVideoByPrimaryKey(Integer vid,Integer webId);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public Video getVideoByPrimaryKey(Integer vid,Integer webId);

}