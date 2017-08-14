package com.crawl.acfun.http;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.acfun.dao.CategoryDao;
import com.crawl.acfun.dao.VideoListDao;
import com.crawl.acfun.entity.param.CategoryParam;
import com.crawl.acfun.entity.param.VideoListParam;
import com.crawl.acfun.entity.po.Category;
import com.crawl.acfun.entity.po.VideoList;
import com.crawl.util.HttpUtils;

public class VideoListCrawl {

	private static Logger logger = LoggerFactory.getLogger(VideoListCrawl.class);
	// static Set<Integer> idSet = new HashSet<Integer>();

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		VideoListDao<VideoList, VideoListParam> videoDao = ctx.getBean(VideoListDao.class);

		// http://acfun.cn/list/getlist?channelId=85&sort=0&pageSize=20&pageNo=2
		CategoryDao<Category, CategoryParam> categoryDao = ctx.getBean(CategoryDao.class);
		//
		List<Category> categoryList = categoryDao.getCategoryList(false);
		for (Category category : categoryList) {
			// System.out.println(category.getName() + ", " +
			// category.getPid());
			int channelId = category.getId();
			if (channelId == 85){
				continue;
			}
			
			for (int pageNo = 1; pageNo <= 500; pageNo++) {
				// int channelId = category.getId();

				
				try {

					int ret = crawPage(channelId, 0, pageNo, videoDao);
					if (ret <= 1){
						break;
					}
					Thread.sleep(500);
				} catch (Exception e) {
					System.out.println("Craw channel " + channelId + " failed!");
				}
			}

		}

		// System.out.println(idSet.size());
		Thread.sleep(10000);
		// ctx.close();
	}

	public static int crawPage(int channelId, int sort, Integer pageNo,
			VideoListDao<VideoList, VideoListParam> videoDao) throws Exception {

		String url = "http://acfun.cn/list/getlist?channelId=" + channelId + "&sort=" + sort + "&pageSize=20&pageNo="
				+ pageNo;
		System.out.println(url);
		String resp = HttpUtils.doGet(url, null, "utf-8");
		System.out.println(resp);
		JSONObject jsonObj = new JSONObject(resp);
		String msg = jsonObj.getString("errmsg");
		int status = jsonObj.getInt("errno");
		JSONObject jsonData = jsonObj.getJSONObject("data");
		JSONObject paramData = jsonData.getJSONObject("params");
		int pageCount = paramData.getInt("pageCount");
		int totalCount = paramData.getInt("totalCount");

		JSONArray dataArray = jsonData.getJSONArray("data");
		Integer inserted = 0;
		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject obj = dataArray.getJSONObject(i);
			VideoList video = VideoList.fromJson(obj);
			// video.setWebId(1);
			if (videoDao.selectByPrimaryKey(video.getId()) == null) {
				try {
					if (videoDao.insert(video) > 0){
						inserted++;
					}
				} catch (Exception ex) {
					logger.error("Insert VideoList failed, video " + video);
					// ex.printStackTrace();
					continue;
				}
			}
			// if (!idSet.add(video.getId())) {
			// System.out.println("Duplicate id: " + video.getId());
			// }
		}
		System.out.println("==========PageNo: " + channelId + ", records: " + inserted);
		return inserted;
	}

}
