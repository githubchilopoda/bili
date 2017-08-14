package com.crawl.acfun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.acfun.entity.enums.PageSize;
import com.crawl.acfun.entity.param.UploaderParam;
import com.crawl.acfun.entity.po.Uploader;
import com.crawl.acfun.entity.vo.PaginationResult;
import com.crawl.acfun.entity.vo.SimplePage;
import com.crawl.acfun.dao.UploaderDao;
import com.crawl.acfun.service.UploaderService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("uploaderService")
public class UploaderServiceImpl implements UploaderService {

	@Resource
	private UploaderDao<Uploader,UploaderParam> uploaderDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<Uploader> findListByPage(UploaderParam param) {
		int count = this.uploaderDao.selectCount(param);
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
		List<Uploader> list = this.uploaderDao.selectList(param);
		PaginationResult<Uploader> result = new PaginationResult<Uploader>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(Uploader bean){
		return this.uploaderDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(Uploader bean){
		return this.uploaderDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(Uploader bean){
		return this.uploaderDao.delete(bean);
	}
}