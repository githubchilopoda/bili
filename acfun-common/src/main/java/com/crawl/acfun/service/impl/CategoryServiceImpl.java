package com.crawl.acfun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.acfun.entity.enums.PageSize;
import com.crawl.acfun.entity.param.CategoryParam;
import com.crawl.acfun.entity.po.Category;
import com.crawl.acfun.entity.vo.PaginationResult;
import com.crawl.acfun.entity.vo.SimplePage;
import com.crawl.acfun.dao.CategoryDao;
import com.crawl.acfun.service.CategoryService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryDao<Category,CategoryParam> categoryDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<Category> findListByPage(CategoryParam param) {
		int count = this.categoryDao.selectCount(param);
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
		List<Category> list = this.categoryDao.selectList(param);
		PaginationResult<Category> result = new PaginationResult<Category>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(Category bean){
		return this.categoryDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(Category bean){
		return this.categoryDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(Category bean){
		return this.categoryDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteCategoryByPrimaryKey(Integer id){
		return this.categoryDao.deleteByPrimaryKey(id);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public Category getCategoryByPrimaryKey(Integer id){
		return this.categoryDao.selectByPrimaryKey(id);
	}

}