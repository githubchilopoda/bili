package com.crawl.acfun.main;

import java.util.Date;

import javax.annotation.Resource;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.crawl.acfun.dao.UploaderDao;
import com.crawl.acfun.entity.param.UploaderParam;
import com.crawl.acfun.entity.po.Uploader;
import com.geccocrawler.gecco.pipeline.Pipeline;

/**
 * Created by Administrator on 2017/6/30.
 */
@Service("uploaderPipeline")
public class UploaderPipeline implements Pipeline<UploaderBean> {
	
	@Resource
	private UploaderDao<Uploader, UploaderParam> uploaderDao;
	
	
	@Override
	public void process(UploaderBean bean) {
		// 保存当前页爬取的图片信息

		String js = bean.getJsScript();

		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByExtension("js");

		try {
			engine.eval(js);
			String jsonStr = (String)engine.eval("JSON.stringify(UPUser)");
			String pageCountStr = (String)engine.eval("JSON.stringify(pageCount)");
			
			Uploader uploader = JSONObject.parseObject(jsonStr, Uploader.class);
			
			PageCount pageCount = JSONObject.parseObject(pageCountStr, PageCount.class);
			uploader.setArticle(pageCount.getArticle());
			uploader.setCollection(pageCount.getCollection());
			uploader.setWebId(1);
			uploader.setVideo(pageCount.getVideo());
			uploader.setCreateDate(new Date());
			uploader.setLastGrabDate(new Date());
			uploader.setUid(bean.getUid());

			System.out.println(uploader);
			
			int ret = uploaderDao.insert(uploader);
			System.out.println(ret);
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
