package com.crawl.acfun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.acfun.entity.enums.PageSize;
import com.crawl.acfun.entity.param.AcfunVideoParam;
import com.crawl.acfun.entity.po.AcfunVideo;
import com.crawl.acfun.entity.vo.PaginationResult;
import com.crawl.acfun.entity.vo.SimplePage;
import com.crawl.acfun.dao.AcfunVideoDao;
import com.crawl.acfun.service.AcfunVideoService;


/**
 * 
 *  业务接口实现
 * 
 */
@Service("acfunVideoService")
public class AcfunVideoServiceImpl implements AcfunVideoService {

	@Resource
	private AcfunVideoDao<AcfunVideo,AcfunVideoParam> acfunVideoDao;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	public PaginationResult<AcfunVideo> findListByPage(AcfunVideoParam param) {
		int count = this.acfunVideoDao.selectCount(param);
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
		List<AcfunVideo> list = this.acfunVideoDao.selectList(param);
		PaginationResult<AcfunVideo> result = new PaginationResult<AcfunVideo>(page, list);
		return result;
	}

	/**
	 * 
	 * 新增
	 * 
	 */
	public Integer add(AcfunVideo bean){
		return this.acfunVideoDao.insert(bean);
	}

	/**
	 * 
	 * 修改
	 * 
	 */
	public Integer update(AcfunVideo bean){
		return this.acfunVideoDao.update(bean);
	}

	/**
	 * 
	 * 删除
	 * 
	 */
	public Integer delete(AcfunVideo bean){
		return this.acfunVideoDao.delete(bean);
	}

	/**
	 * 
	 * 根据primaryKey删除
	 * 
	 */
	 public Integer deleteAcfunVideoByPrimaryKey(Integer id,Integer webId){
		return this.acfunVideoDao.deleteByPrimaryKey(id,webId);
	}


	/**
	 * 
	 * 根据primaryKey获取对象
	 * 
	 */
	 public AcfunVideo getAcfunVideoByPrimaryKey(Integer id,Integer webId){
		return this.acfunVideoDao.selectByPrimaryKey(id,webId);
	}

}