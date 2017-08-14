package com.crawl.acfun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.acfun.entity.enums.PageSize;
import com.crawl.acfun.entity.param.WebParam;
import com.crawl.acfun.entity.po.Web;
import com.crawl.acfun.entity.vo.PaginationResult;
import com.crawl.acfun.entity.vo.SimplePage;
import com.crawl.acfun.dao.WebDao;
import com.crawl.acfun.service.WebService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("webService")
public class WebServiceImpl implements WebService {

	@Resource
	private WebDao<Web,WebParam> webDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<Web> findListByPage(WebParam param) {
		int count = this.webDao.selectCount(param);
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
		List<Web> list = this.webDao.selectList(param);
		PaginationResult<Web> result = new PaginationResult<Web>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(Web bean){
		return this.webDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(Web bean){
		return this.webDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(Web bean){
		return this.webDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteWebByPrimaryKey(Integer webId){
		return this.webDao.deleteByPrimaryKey(webId);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public Web getWebByPrimaryKey(Integer webId){
		return this.webDao.selectByPrimaryKey(webId);
	}

}