package com.crawl.webchat.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.webchat.entity.enums.PageSize;
import com.crawl.webchat.entity.param.WxAccountParam;
import com.crawl.webchat.entity.po.WxAccount;
import com.crawl.webchat.entity.vo.PaginationResult;
import com.crawl.webchat.entity.vo.SimplePage;
import com.crawl.webchat.dao.WxAccountDao;
import com.crawl.webchat.service.WxAccountService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("wxAccountService")
public class WxAccountServiceImpl implements WxAccountService {

	@Resource
	private WxAccountDao<WxAccount,WxAccountParam> wxAccountDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<WxAccount> findListByPage(WxAccountParam param) {
		int count = this.wxAccountDao.selectCount(param);
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
		List<WxAccount> list = this.wxAccountDao.selectList(param);
		PaginationResult<WxAccount> result = new PaginationResult<WxAccount>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(WxAccount bean){
		return this.wxAccountDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(WxAccount bean){
		return this.wxAccountDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(WxAccount bean){
		return this.wxAccountDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteWxAccountByPrimaryKey(String account){
		return this.wxAccountDao.deleteByPrimaryKey(account);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public WxAccount getWxAccountByPrimaryKey(String account){
		return this.wxAccountDao.selectByPrimaryKey(account);
	}

}