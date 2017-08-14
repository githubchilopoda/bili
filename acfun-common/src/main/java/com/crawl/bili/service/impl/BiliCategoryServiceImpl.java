package com.crawl.bili.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.bili.entity.enums.PageSize;
import com.crawl.bili.entity.param.BiliCategoryParam;
import com.crawl.bili.entity.po.BiliCategory;
import com.crawl.bili.entity.vo.PaginationResult;
import com.crawl.bili.entity.vo.SimplePage;
import com.crawl.bili.dao.BiliCategoryDao;
import com.crawl.bili.service.BiliCategoryService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("biliCategoryService")
public class BiliCategoryServiceImpl implements BiliCategoryService {

	@Resource
	private BiliCategoryDao<BiliCategory,BiliCategoryParam> biliCategoryDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<BiliCategory> findListByPage(BiliCategoryParam param) {
		int count = this.biliCategoryDao.selectCount(param);
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
		List<BiliCategory> list = this.biliCategoryDao.selectList(param);
		PaginationResult<BiliCategory> result = new PaginationResult<BiliCategory>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(BiliCategory bean){
		return this.biliCategoryDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(BiliCategory bean){
		return this.biliCategoryDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(BiliCategory bean){
		return this.biliCategoryDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteBiliCategoryByPrimaryKey(Integer id){
		return this.biliCategoryDao.deleteByPrimaryKey(id);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public BiliCategory getBiliCategoryByPrimaryKey(Integer id){
		return this.biliCategoryDao.selectByPrimaryKey(id);
	}

}