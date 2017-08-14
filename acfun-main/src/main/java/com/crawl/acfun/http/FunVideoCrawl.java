package com.crawl.acfun.http;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.crawl.acfun.dao.AcfunVideoDao;
import com.crawl.acfun.entity.param.AcfunVideoParam;
import com.crawl.acfun.entity.po.AcfunVideo;
import com.crawl.util.HttpUtils;

public class FunVideoCrawl {

	private static Logger logger = LoggerFactory.getLogger(FunVideoCrawl.class);
	//static Set<Integer> idSet = new HashSet<Integer>();

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		AcfunVideoDao<AcfunVideo, AcfunVideoParam> videoDao = ctx.getBean(AcfunVideoDao.class);

		for (int pageNo = 1; pageNo <= 9; pageNo++) {
			if (pageNo != 4) {
				// continue;
			}

			try {
				crawPage(pageNo, videoDao);
			} catch (Exception e) {
				System.out.println("Craw page " + pageNo + " failed!");
				continue;
			}
		}
		//System.out.println(idSet.size());
		Thread.sleep(10000);
		// ctx.close();
	}

	public static void crawPage(int pageNo, AcfunVideoDao<AcfunVideo, AcfunVideoParam> videoDao) throws Exception {
		String url = "http://www.acfun.cn/bangumi/bangumi/page?pageSize=42&isWeb=1&pageNo=" + pageNo + "&sort=1";

		// AcfunVideo video =videoDao.selectByPrimaryKey(1, 1);
		// if (video != null){
		// System.out.println(video);
		// }

		if (pageNo == 4) {
			System.out.println("");
		}
		String resp = HttpUtils.doGet(url, null, "utf-8");
		JSONObject jsonObj = new JSONObject(resp);
		boolean success = jsonObj.getBoolean("success");
		String msg = jsonObj.getString("msg");
		int status = jsonObj.getInt("status");
		JSONObject jsonData = jsonObj.getJSONObject("data");
		// int pageNo = jsonData.getInt("pageNo");
		int totalPage = jsonData.getInt("totalPage");
		int pageSize = jsonData.getInt("pageSize");
		int totalCount = jsonData.getInt("totalCount");

		JSONArray dataArray = jsonData.getJSONArray("list");

		for (int i = 0; i < dataArray.length(); i++) {
			JSONObject obj = dataArray.getJSONObject(i);
			AcfunVideo video = AcfunVideo.fromJson(obj);
			video.setWebId(1);
			if (videoDao.selectByPrimaryKey(video.getId(), 1) == null) {
				try {
					videoDao.insert(video);
				} catch (Exception ex) {
					logger.error("Insert AcfunVideo failed, video " + video);
					//ex.printStackTrace();
					continue;
				}
			}
//			if (!idSet.add(video.getId())) {
//				System.out.println("Duplicate id: " + video.getId());
//			}
		}
		System.out.println("==========PageNo: " + pageNo + ", records: " + dataArray.length());
	}

}
