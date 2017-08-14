package com.crawl.acfun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.acfun.entity.enums.PageSize;
import com.crawl.acfun.entity.param.VideoParam;
import com.crawl.acfun.entity.po.Video;
import com.crawl.acfun.entity.vo.PaginationResult;
import com.crawl.acfun.entity.vo.SimplePage;
import com.crawl.acfun.dao.VideoDao;
import com.crawl.acfun.service.VideoService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("videoService")
public class VideoServiceImpl implements VideoService {

	@Resource
	private VideoDao<Video,VideoParam> videoDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<Video> findListByPage(VideoParam param) {
		int count = this.videoDao.selectCount(param);
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
		List<Video> list = this.videoDao.selectList(param);
		PaginationResult<Video> result = new PaginationResult<Video>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(Video bean){
		return this.videoDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(Video bean){
		return this.videoDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(Video bean){
		return this.videoDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteVideoByPrimaryKey(Integer vid,Integer webId){
		return this.videoDao.deleteByPrimaryKey(vid,webId);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public Video getVideoByPrimaryKey(Integer vid,Integer webId){
		return this.videoDao.selectByPrimaryKey(vid,webId);
	}

}