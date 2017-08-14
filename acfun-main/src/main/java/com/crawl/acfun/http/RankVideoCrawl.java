package com.crawl.acfun.http;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.acfun.dao.CategoryDao;
import com.crawl.acfun.dao.RankVideoDao;
import com.crawl.acfun.entity.param.CategoryParam;
import com.crawl.acfun.entity.param.RankVideoParam;
import com.crawl.acfun.entity.po.Category;
import com.crawl.acfun.entity.po.RankVideo;
import com.crawl.util.HttpUtils;

public class RankVideoCrawl {

	private static Logger logger = LoggerFactory.getLogger(RankVideoCrawl.class);
	// static Set<Integer> idSet = new HashSet<Integer>();

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		RankVideoDao<RankVideo, RankVideoParam> videoDao = ctx.getBean(RankVideoDao.class);

		CategoryDao<Category, CategoryParam> categoryDao = ctx.getBean(CategoryDao.class);
		
		List<Category> categoryList = categoryDao.getCategoryList(false);
		for (Category category: categoryList){
			//System.out.println(category.getName() + ", " + category.getPid());
			
			int channelId = category.getId();
			try {

				crawPage(channelId, 3, 120, videoDao);
			} catch (Exception e) {
				System.out.println("Craw channel " + channelId + " failed!");

			}
			
		}
		
		
		
		

		// System.out.println(idSet.size());
		Thread.sleep(10000);
		// ctx.close();
	}

	public static void crawPage(int channelId, int range, Integer count,
			RankVideoDao<RankVideo, RankVideoParam> videoDao) throws Exception {
		if (count == null) {
			count = 30;
		}
		String url = "http://www.acfun.cn/rank.aspx?channelId=" + channelId + "&range=" + range + "&count=" + count
				+ "&ext=1&date=";
		System.out.println(url);
		String resp = HttpUtils.doGet(url, null, "utf-8");

		JSONArray dataArray = new JSONArray(resp);

		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject obj = dataArray.getJSONObject(i);
			RankVideo video = RankVideo.fromJson(obj);
			video.setWebId(1);
			if (videoDao.selectByPrimaryKey(video.getId(), 1) == null) {
				try {
					videoDao.insert(video);
				} catch (Exception ex) {
					logger.error("Insert RankVideo failed, video " + video);
					// ex.printStackTrace();
					continue;
				}
			}
			// if (!idSet.add(video.getId())) {
			// System.out.println("Duplicate id: " + video.getId());
			// }
		}
		System.out.println("==========PageNo: " + channelId + ", records: " + dataArray.length());
	}

}
