package com.crawl.bili.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.bili.entity.enums.PageSize;
import com.crawl.bili.entity.param.BiliUserParam;
import com.crawl.bili.entity.po.BiliUser;
import com.crawl.bili.entity.vo.PaginationResult;
import com.crawl.bili.entity.vo.SimplePage;
import com.crawl.bili.dao.BiliUserDao;
import com.crawl.bili.service.BiliUserService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("biliUserService")
public class BiliUserServiceImpl implements BiliUserService {

	@Resource
	private BiliUserDao<BiliUser,BiliUserParam> biliUserDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<BiliUser> findListByPage(BiliUserParam param) {
		int count = this.biliUserDao.selectCount(param);
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
		List<BiliUser> list = this.biliUserDao.selectList(param);
		PaginationResult<BiliUser> result = new PaginationResult<BiliUser>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(BiliUser bean){
		return this.biliUserDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(BiliUser bean){
		return this.biliUserDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(BiliUser bean){
		return this.biliUserDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteBiliUserByPrimaryKey(Integer mid){
		return this.biliUserDao.deleteByPrimaryKey(mid);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public BiliUser getBiliUserByPrimaryKey(Integer mid){
		return this.biliUserDao.selectByPrimaryKey(mid);
	}

}