package com.crawl.bilibili;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.bili.dao.BiliCategoryDao;
import com.crawl.bili.dao.BiliFunDao;
import com.crawl.bili.dao.BiliUserDao;
import com.crawl.bili.entity.param.BiliCategoryParam;
import com.crawl.bili.entity.param.BiliFunParam;
import com.crawl.bili.entity.param.BiliUserParam;
import com.crawl.bili.entity.po.BiliCategory;
import com.crawl.bili.entity.po.BiliFun;
import com.crawl.bili.entity.po.BiliUser;
import com.crawl.util.FileUtil;
import com.crawl.util.HttpUtils;

public class UserByID {

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		BiliUserDao<BiliUser, BiliUserParam> biliUserDao = context.getBean(BiliUserDao.class);
		BiliCategoryDao<BiliCategory, BiliCategoryParam> biliCategoryDao = context.getBean(BiliCategoryDao.class);

		// HttpRequest request = new HttpRequest();
		// HttpClient httpClient = HttpClientBuilder.create().build();
		// HttpPost post = new HttpPost("");
		// //httpClient.getConnectionManager().getParams().setConnectionTimeout(60000);
		// post.addHeader("Host","space.bilibili.com");
		// post.addHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64;
		// rv:52.0) Gecko/20100101 Firefox/52.0");
		// post.addHeader("Accept","application/json, text/plain, */*");
		// post.addHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		// post.addHeader("Accept-Encoding","gzip, deflate, br");
		// post.addHeader("X-Requested-With","XMLHttpRequest");
		// post.addHeader("Content-Type","application/x-www-form-urlencoded");
		// post.addHeader("Referer","http://space.bilibili.com/10513807/");
		// HttpResponse response = httpClient.execute(post);
		// response.get
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Host", "space.bilibili.com");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0");
		headers.put("Accept", "application/json, text/plain, */*");
		headers.put("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		headers.put("Accept-Encoding", "gzip, deflate, br");
		headers.put("X-Requested-With", "XMLHttpRequest");
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		headers.put("Referer", "http://space.bilibili.com/10513807/");
		String url = "http://space.bilibili.com/ajax/member/GetInfo";
		new File("htmls/users").mkdirs();
		new File("htmls/users2").mkdirs();
		new File("htmls/users4").mkdirs();		
		
		for (int i = 303271; i <= 400000; i++) {	
			Map<String, String> params = new HashMap<String, String>();
			params.put("mid", i + "");
			try {
				String response = HttpUtils.doPost(url, params, headers, "utf-8");
				FileUtil.filePutContent("htmls/users4/" + i + ".json", response, "utf-8");
				JSONObject retData = new JSONObject(response);

				JSONObject data = retData.getJSONObject("data");
				BiliUser user = BiliUser.fromJson(data);
				biliUserDao.insert(user);
			} catch (Exception e) {
				continue;
			}
		}
		// System.out.println(response);
	}

	public static void doCrawl() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		BiliFunDao<BiliFun, BiliFunParam> biliFunDao = context.getBean(BiliFunDao.class);
		BiliCategoryDao<BiliCategory, BiliCategoryParam> biliCategoryDao = context.getBean(BiliCategoryDao.class);
		// String topDir = "F:\\develop\\acfun\\acfun-main\\htmls\\video";
		List<BiliCategory> categoryList = biliCategoryDao.getCategoryList(false);
		for (BiliCategory category : categoryList) {
			if (category.getId() <= 0) {
				continue;
			}
			crawlCategory(category.getId(), biliFunDao);
		}
	}

	// public BiliFun getByById(int aid){
	// String url = "http://api.bilibili.com/archive_stat/stat?aid=" + aid;
	// String content = HttpUtils.doGet(url, null, "utf-8");
	//
	// }
	
	public static class CrawlJob implements Runnable{
		public CrawlJob(){
			
			
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}
	

	public static int crawlCategory(int categoryId, BiliFunDao<BiliFun, BiliFunParam> biliFunDao) {
		String url = "https://api.bilibili.com/archive_rank/getarchiverankbypartion?tid=%d&pn=%d";
		String sDir = "processed/video/tid_" + categoryId + "/";
		String errorDir = "error/video/tid_" + categoryId + "/";
		new File(sDir).mkdirs();
		new File(errorDir).mkdirs();
		File dir = new File(sDir);
		dir.mkdirs();
		int startPage = 1;
		if (categoryId == 24) {

			startPage = 2414;
		}
		for (int pn = startPage;; pn++) {
			String fullUrl = String.format(url, categoryId, pn);
			String content = HttpUtils.doGet(fullUrl, null, "utf-8");

			String fileName = sDir + pn + ".json";
			FileUtil.filePutContent(fileName, content, "utf-8");

			try {
				JSONObject retData = new JSONObject(content);
				// if (!retData.has("data")){
				// continue;
				// }

				JSONArray dataArray = retData.getJSONObject("data").getJSONArray("archives");
				List<BiliFun> dataList = new ArrayList<BiliFun>();
				for (int i = 0; i < dataArray.length(); i++) {
					JSONObject jsonObj = dataArray.getJSONObject(i);
					BiliFun biliFun = BiliFun.fromJson(jsonObj);
					biliFun.setCrawlTime(new Date());
					// System.out.println(biliFun);
					// biliFunDao.insert(biliFun);
					// break;
					dataList.add(biliFun);
				}
				int num = biliFunDao.insertBatch(dataList);
				if (num <= 1) {
					break;
				}
			} catch (Exception e) {
				FileUtil.filePutContent(errorDir + pn + ".json", content, "utf-8");
				break;
			}
			// break;
		}
		return 0;
	}

	public static void testAdd() throws Exception {
		int tid = 33; // 连载动画
		tid = 32; // 完结动画
		tid = 153; // 国产动画
		tid = 171; // 电子竞技
		// tid = 172; //手机游戏
		// tid = 17; // 单机游戏
		// tid = 65; // 网络游戏
		// tid = 173; // 桌游棋牌
		// tid = 121; // GMV
		// tid = 136; // 音游
		// tid = 19; // Mugen
		tid = 154; // 三次元舞蹈
		tid = 156; // 舞蹈教程
		tid = 20;
		tid = 82;
		tid = 71; // 综艺
		tid = 137; // 明星
		tid = 131; // korea
		int maxPage = 26962; // 国产动画
		// maxPage = 9727;
		// maxPage = 72224;
		// maxPage = 27454; // 网络游戏
		// maxPage = 3413; // 桌游棋牌
		// maxPage = 2016; // GMV
		// maxPage = 4510; // 音游
		// maxPage = 1553; // mugen
		maxPage = 3101;
		maxPage = 371;
		maxPage = 4427;
		maxPage = 9830;
		maxPage = 10328;
		maxPage = 20441;
		maxPage = 17698;
		String url = "https://api.bilibili.com/archive_rank/getarchiverankbypartion?tid=%d&pn=%d";
		// long timestamp = System.currentTimeMillis();
		// &_=1501928192983
		String sDir = "htmls/video/tid_" + tid + "/";
		File dir = new File(sDir);
		dir.mkdirs();
		for (int pn = 1; pn <= maxPage; pn++) {
			String fullUrl = String.format(url, tid, pn);
			String content = HttpUtils.doGet(fullUrl, null, "utf-8");

			String fileName = sDir + pn + ".json";
			FileUtil.filePutContent(fileName, content, "utf-8");
			Thread.sleep(500);
			// break;
		}
	}


}
