package com.crawl.webchat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.webchat.entity.enums.PageSize;
import com.crawl.webchat.entity.param.NewRankDayParam;
import com.crawl.webchat.entity.po.NewRankDay;
import com.crawl.webchat.entity.vo.PaginationResult;
import com.crawl.webchat.entity.vo.SimplePage;
import com.crawl.webchat.dao.NewRankDayDao;
import com.crawl.webchat.service.NewRankDayService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("newRankDayService")
public class NewRankDayServiceImpl implements NewRankDayService {

	@Resource
	private NewRankDayDao<NewRankDay,NewRankDayParam> newRankDayDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<NewRankDay> findListByPage(NewRankDayParam param) {
		int count = this.newRankDayDao.selectCount(param);
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
		List<NewRankDay> list = this.newRankDayDao.selectList(param);
		PaginationResult<NewRankDay> result = new PaginationResult<NewRankDay>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(NewRankDay bean){
		return this.newRankDayDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(NewRankDay bean){
		return this.newRankDayDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(NewRankDay bean){
		return this.newRankDayDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteNewRankDayByPrimaryKey(Integer rank,String categoryName,java.util.Date day){
		return this.newRankDayDao.deleteByPrimaryKey(rank,categoryName,day);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public NewRankDay getNewRankDayByPrimaryKey(Integer rank,String categoryName,java.util.Date day){
		return this.newRankDayDao.selectByPrimaryKey(rank,categoryName,day);
	}

}