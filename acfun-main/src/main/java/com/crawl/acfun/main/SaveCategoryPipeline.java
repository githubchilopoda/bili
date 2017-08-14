package com.crawl.acfun.main;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.crawl.acfun.dao.CategoryDao;
import com.crawl.acfun.entity.param.CategoryParam;
import com.crawl.acfun.entity.po.Category;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.HrefBean;

/**
 * Created by Administrator on 2017/6/30.
 */
@Service("saveCategoryPipeline")
public class SaveCategoryPipeline implements Pipeline<RankBean> {
	
	@Resource
	private CategoryDao<Category, CategoryParam> categoryDao;
	
	
	@Override
	public void process(RankBean bean) {
		// 保存当前页爬取的图片信息

		//ScriptEngineManager mgr = new ScriptEngineManager();
		//ScriptEngine engine = mgr.getEngineByExtension("js");

		try {
//			List<HrefBean> catList = bean.getCategoryList();
//			for (HrefBean cat: catList){
//				String url = cat.getUrl();
//				if (url.indexOf(";") > 0){
//					continue;
//				}
//				
//				int pos = url.indexOf("=");
//				Integer cid = Integer.parseInt(url.substring(pos+1));
//				Category category = new Category();
//				category.setId(cid);
//				category.setName(cat.getTitle());
//				
//				categoryDao.insert(category);
//				System.out.println(cid + "," + cat.getUrl() + ", " + cat.getTitle());
//			}
			
			List<HrefBean> catList = bean.getTopCategoryList();
			for (HrefBean cat: catList){
				String url = cat.getUrl();
				int pos1 = url.indexOf("list");
				if (pos1 <= 0){
					continue;
				}
				int pos2 = url.indexOf("/", pos1);
				Integer cid = Integer.parseInt(url.substring(pos1 + 4, pos2));
				Category category = new Category();
				category.setId(cid);
				category.setName(cat.getTitle());
				try {
				categoryDao.insert(category);
				}catch (Exception ex){
					continue;
				}
				System.out.println(cid + "," + cat.getUrl() + ", " + cat.getTitle());
			}
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
