package com.crawl.webchat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.webchat.entity.enums.PageSize;
import com.crawl.webchat.entity.param.WeiboWeekRankParam;
import com.crawl.webchat.entity.po.WeiboWeekRank;
import com.crawl.webchat.entity.vo.PaginationResult;
import com.crawl.webchat.entity.vo.SimplePage;
import com.crawl.webchat.dao.WeiboWeekRankDao;
import com.crawl.webchat.service.WeiboWeekRankService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("weiboWeekRankService")
public class WeiboWeekRankServiceImpl implements WeiboWeekRankService {

	@Resource
	private WeiboWeekRankDao<WeiboWeekRank,WeiboWeekRankParam> weiboWeekRankDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<WeiboWeekRank> findListByPage(WeiboWeekRankParam param) {
		int count = this.weiboWeekRankDao.selectCount(param);
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
		List<WeiboWeekRank> list = this.weiboWeekRankDao.selectList(param);
		PaginationResult<WeiboWeekRank> result = new PaginationResult<WeiboWeekRank>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(WeiboWeekRank bean){
		return this.weiboWeekRankDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(WeiboWeekRank bean){
		return this.weiboWeekRankDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(WeiboWeekRank bean){
		return this.weiboWeekRankDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteWeiboWeekRankByPrimaryKey(Integer rank,Integer type,java.util.Date dayBegin){
		return this.weiboWeekRankDao.deleteByPrimaryKey(rank,type,dayBegin);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public WeiboWeekRank getWeiboWeekRankByPrimaryKey(Integer rank,Integer type,java.util.Date dayBegin){
		return this.weiboWeekRankDao.selectByPrimaryKey(rank,type,dayBegin);
	}

}