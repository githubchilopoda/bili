package com.crawl.bili.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.bili.entity.enums.PageSize;
import com.crawl.bili.entity.param.BiliVideoParam;
import com.crawl.bili.entity.po.BiliVideo;
import com.crawl.bili.entity.vo.PaginationResult;
import com.crawl.bili.entity.vo.SimplePage;
import com.crawl.bili.dao.BiliVideoDao;
import com.crawl.bili.service.BiliVideoService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("biliVideoService")
public class BiliVideoServiceImpl implements BiliVideoService {

	@Resource
	private BiliVideoDao<BiliVideo,BiliVideoParam> biliVideoDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<BiliVideo> findListByPage(BiliVideoParam param) {
		int count = this.biliVideoDao.selectCount(param);
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
		List<BiliVideo> list = this.biliVideoDao.selectList(param);
		PaginationResult<BiliVideo> result = new PaginationResult<BiliVideo>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(BiliVideo bean){
		return this.biliVideoDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(BiliVideo bean){
		return this.biliVideoDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(BiliVideo bean){
		return this.biliVideoDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteBiliVideoByPrimaryKey(Integer aid){
		return this.biliVideoDao.deleteByPrimaryKey(aid);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public BiliVideo getBiliVideoByPrimaryKey(Integer aid){
		return this.biliVideoDao.selectByPrimaryKey(aid);
	}

}