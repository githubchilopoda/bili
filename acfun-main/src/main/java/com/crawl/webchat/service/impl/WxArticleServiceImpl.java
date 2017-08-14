package com.crawl.webchat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.webchat.entity.enums.PageSize;
import com.crawl.webchat.entity.param.WxArticleParam;
import com.crawl.webchat.entity.po.WxArticle;
import com.crawl.webchat.entity.vo.PaginationResult;
import com.crawl.webchat.entity.vo.SimplePage;
import com.crawl.webchat.dao.WxArticleDao;
import com.crawl.webchat.service.WxArticleService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("wxArticleService")
public class WxArticleServiceImpl implements WxArticleService {

	@Resource
	private WxArticleDao<WxArticle,WxArticleParam> wxArticleDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<WxArticle> findListByPage(WxArticleParam param) {
		int count = this.wxArticleDao.selectCount(param);
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
		List<WxArticle> list = this.wxArticleDao.selectList(param);
		PaginationResult<WxArticle> result = new PaginationResult<WxArticle>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(WxArticle bean){
		return this.wxArticleDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(WxArticle bean){
		return this.wxArticleDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(WxArticle bean){
		return this.wxArticleDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteWxArticleByPrimaryKey(Long mid){
		return this.wxArticleDao.deleteByPrimaryKey(mid);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public WxArticle getWxArticleByPrimaryKey(Long mid){
		return this.wxArticleDao.selectByPrimaryKey(mid);
	}

}