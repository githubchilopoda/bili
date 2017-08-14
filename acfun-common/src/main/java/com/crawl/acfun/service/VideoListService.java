package com.crawl.acfun.service;

import com.crawl.acfun.entity.param.VideoListParam;
import com.crawl.acfun.entity.po.VideoList;
import com.crawl.acfun.entity.vo.PaginationResult;


/**
 * 
 *  业务接口
 * 
 */
public interface VideoListService {

	/**
	 * 
	 * 分页查询
	 * 
	 */
	public PaginationResult<VideoList> findListByPage(VideoListParam param);

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(VideoList bean);

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(VideoList bean);

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(VideoList bean);

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteVideoListByPrimaryKey(Integer id);


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public VideoList getVideoListByPrimaryKey(Integer id);

}