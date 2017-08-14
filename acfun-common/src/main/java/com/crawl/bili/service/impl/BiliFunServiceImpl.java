package com.crawl.bili.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.bili.entity.enums.PageSize;
import com.crawl.bili.entity.param.BiliFunParam;
import com.crawl.bili.entity.po.BiliFun;
import com.crawl.bili.entity.vo.PaginationResult;
import com.crawl.bili.entity.vo.SimplePage;
import com.crawl.bili.dao.BiliFunDao;
import com.crawl.bili.service.BiliFunService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("biliFunService")
public class BiliFunServiceImpl implements BiliFunService {

	@Resource
	private BiliFunDao<BiliFun,BiliFunParam> biliFunDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<BiliFun> findListByPage(BiliFunParam param) {
		int count = this.biliFunDao.selectCount(param);
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
		List<BiliFun> list = this.biliFunDao.selectList(param);
		PaginationResult<BiliFun> result = new PaginationResult<BiliFun>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(BiliFun bean){
		return this.biliFunDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(BiliFun bean){
		return this.biliFunDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(BiliFun bean){
		return this.biliFunDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteBiliFunByPrimaryKey(Integer aid){
		return this.biliFunDao.deleteByPrimaryKey(aid);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public BiliFun getBiliFunByPrimaryKey(Integer aid){
		return this.biliFunDao.selectByPrimaryKey(aid);
	}

}