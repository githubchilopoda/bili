package com.crawl.webchat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.webchat.entity.enums.PageSize;
import com.crawl.webchat.entity.param.PgcWeekRankParam;
import com.crawl.webchat.entity.po.PgcWeekRank;
import com.crawl.webchat.entity.vo.PaginationResult;
import com.crawl.webchat.entity.vo.SimplePage;
import com.crawl.webchat.dao.PgcWeekRankDao;
import com.crawl.webchat.service.PgcWeekRankService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("pgcWeekRankService")
public class PgcWeekRankServiceImpl implements PgcWeekRankService {

	@Resource
	private PgcWeekRankDao<PgcWeekRank,PgcWeekRankParam> pgcWeekRankDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<PgcWeekRank> findListByPage(PgcWeekRankParam param) {
		int count = this.pgcWeekRankDao.selectCount(param);
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
		List<PgcWeekRank> list = this.pgcWeekRankDao.selectList(param);
		PaginationResult<PgcWeekRank> result = new PaginationResult<PgcWeekRank>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(PgcWeekRank bean){
		return this.pgcWeekRankDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(PgcWeekRank bean){
		return this.pgcWeekRankDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(PgcWeekRank bean){
		return this.pgcWeekRankDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deletePgcWeekRankByPrimaryKey(Integer rank,Integer categoryId,java.util.Date dayBegin){
		return this.pgcWeekRankDao.deleteByPrimaryKey(rank,categoryId,dayBegin);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public PgcWeekRank getPgcWeekRankByPrimaryKey(Integer rank,Integer categoryId,java.util.Date dayBegin){
		return this.pgcWeekRankDao.selectByPrimaryKey(rank,categoryId,dayBegin);
	}

}