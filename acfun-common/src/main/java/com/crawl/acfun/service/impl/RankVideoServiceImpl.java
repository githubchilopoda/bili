package com.crawl.acfun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.acfun.entity.enums.PageSize;
import com.crawl.acfun.entity.param.RankVideoParam;
import com.crawl.acfun.entity.po.RankVideo;
import com.crawl.acfun.entity.vo.PaginationResult;
import com.crawl.acfun.entity.vo.SimplePage;
import com.crawl.acfun.dao.RankVideoDao;
import com.crawl.acfun.service.RankVideoService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("rankVideoService")
public class RankVideoServiceImpl implements RankVideoService {

	@Resource
	private RankVideoDao<RankVideo,RankVideoParam> rankVideoDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<RankVideo> findListByPage(RankVideoParam param) {
		int count = this.rankVideoDao.selectCount(param);
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
		List<RankVideo> list = this.rankVideoDao.selectList(param);
		PaginationResult<RankVideo> result = new PaginationResult<RankVideo>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(RankVideo bean){
		return this.rankVideoDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(RankVideo bean){
		return this.rankVideoDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(RankVideo bean){
		return this.rankVideoDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteRankVideoByPrimaryKey(Integer id,Integer webId){
		return this.rankVideoDao.deleteByPrimaryKey(id,webId);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public RankVideo getRankVideoByPrimaryKey(Integer id,Integer webId){
		return this.rankVideoDao.selectByPrimaryKey(id,webId);
	}

}