package com.crawl.acfun.main;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.acfun.dao.AcfunVideoDao;
import com.crawl.acfun.entity.param.AcfunVideoParam;
import com.crawl.acfun.entity.po.AcfunVideo;
import com.geccocrawler.gecco.pipeline.Pipeline;

/**
 * Created by Administrator on 2017/6/30.
 */
@Service("acfunVideoPagePipeline")
public class AcfunVideoPagePipeline implements Pipeline<AcfunVideoPage> {
	
	@Resource
	private AcfunVideoDao<AcfunVideo, AcfunVideoParam> acfunVideoDao;
	
	
	@Override
	public void process(AcfunVideoPage bean) {		
		// 保存当前页爬取的图片信息

		

		

		try {			
			System.out.println();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		

		// 继续抓取下一页构造下一页
		// int currPage = bean.getPageNo();
		// int totalPage = bean.getPageData().getPage().getTotalPage();
		// if (currPage < totalPage) {
		// int nextPage = currPage + 1;
		//
		// String nextUrl = bean.getUrl().replace("pageNo=" + currPage,
		// "pageNo=" + nextPage);
		// HttpRequest request = bean.getRequest();
		// SchedulerContext.into(request.subRequest(nextUrl));
		// }
	}
}
