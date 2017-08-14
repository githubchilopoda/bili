package com.crawl.acfun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.acfun.entity.enums.PageSize;
import com.crawl.acfun.entity.param.VideoListParam;
import com.crawl.acfun.entity.po.VideoList;
import com.crawl.acfun.entity.vo.PaginationResult;
import com.crawl.acfun.entity.vo.SimplePage;
import com.crawl.acfun.dao.VideoListDao;
import com.crawl.acfun.service.VideoListService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("videoListService")
public class VideoListServiceImpl implements VideoListService {

	@Resource
	private VideoListDao<VideoList,VideoListParam> videoListDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<VideoList> findListByPage(VideoListParam param) {
		int count = this.videoListDao.selectCount(param);
		int pageSize = param.getPageSize()==null?PageSize.SIZE15.getSize():param.getPageSize();
		if(pageSize <= 0) {
			 pageSize = PageSize.SIZE15.getSize();
		}
		int pageNo = 1;
		if (null != param.getPageNo() && param.getPageNo() > 0) {
			pageNo = param.getPageNo();
		}
		SimplePage page = new SimplePage(pageNo, count, pageSize);
		param.setPage(page);
		List<VideoList> list = this.videoListDao.selectList(param);
		PaginationResult<VideoList> result = new PaginationResult<VideoList>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(VideoList bean){
		return this.videoListDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(VideoList bean){
		return this.videoListDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(VideoList bean){
		return this.videoListDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteVideoListByPrimaryKey(Integer id){
		return this.videoListDao.deleteByPrimaryKey(id);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public VideoList getVideoListByPrimaryKey(Integer id){
		return this.videoListDao.selectByPrimaryKey(id);
	}

}