package com.crawl.bilibili;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.bili.dao.BiliCategoryDao;
import com.crawl.bili.dao.BiliFunDao;
import com.crawl.bili.entity.param.BiliCategoryParam;
import com.crawl.bili.entity.param.BiliFunParam;
import com.crawl.bili.entity.po.BiliCategory;
import com.crawl.bili.entity.po.BiliFun;
import com.crawl.util.FileUtil;
import com.crawl.util.HttpUtils;



public class FunByID {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		BiliFunDao<BiliFun, BiliFunParam> biliFunDao = context.getBean(BiliFunDao.class);
		BiliCategoryDao<BiliCategory, BiliCategoryParam> biliCategoryDao = context.getBean(BiliCategoryDao.class);
		//String topDir = "F:\\develop\\acfun\\acfun-main\\htmls\\video";		
		List<BiliCategory> categoryList = biliCategoryDao.getCategoryList(false);
		for (BiliCategory category: categoryList){
			if (category.getId() <= 0){
				continue;
			}
			crawlCategory(category.getId(), biliFunDao);
		}
	}
	
//	public BiliFun getByById(int aid){
//		String url = "http://api.bilibili.com/archive_stat/stat?aid=" + aid;
//		String content = HttpUtils.doGet(url, null, "utf-8");
//		
//	}
	
	public static int crawlCategory(int categoryId, BiliFunDao<BiliFun, BiliFunParam> biliFunDao){
		String url = "https://api.bilibili.com/archive_rank/getarchiverankbypartion?tid=%d&pn=%d";
		String sDir = "processed/video/tid_" + categoryId + "/";
		String errorDir = "error/video/tid_" + categoryId + "/";
		new File(sDir).mkdirs();
		new File(errorDir).mkdirs();
		File dir = new File(sDir);
		dir.mkdirs();
		int startPage = 1;
		if (categoryId == 24){
			
			startPage = 2414;
		}
		for (int pn = startPage; ; pn++){
			String fullUrl = String.format(url, categoryId, pn);
			String content = HttpUtils.doGet(fullUrl, null, "utf-8");
			
			String fileName = sDir + pn + ".json";
			FileUtil.filePutContent(fileName, content, "utf-8");
			
			try {
				JSONObject retData = new JSONObject(content);
//				if (!retData.has("data")){
//					continue;
//				}
				
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
				if (num <= 1){
					break;
				}
			}catch (Exception e){
				FileUtil.filePutContent(errorDir + pn + ".json", content, "utf-8");
				break;
			}
			//break;			
		}
		return 0;
	}
	
	public static void testAdd() throws Exception{
		int tid = 33; // 连载动画
		tid = 32; // 完结动画
		tid = 153;  // 国产动画
		tid = 171; // 电子竞技
		//tid = 172; //手机游戏
		//tid = 17; // 单机游戏
		//tid = 65; // 网络游戏
		//tid = 173; // 桌游棋牌
		//tid = 121; // GMV
		//tid = 136;  // 音游
		//tid = 19; // Mugen
		tid =154;  //三次元舞蹈
		tid = 156; // 舞蹈教程
		tid = 20;
		tid = 82;
		tid =71; // 综艺
		tid = 137; // 明星
		tid = 131; // korea
		int maxPage = 26962; // 国产动画
		//maxPage = 9727;
		//maxPage = 72224;
		//maxPage = 27454; // 网络游戏
		//maxPage = 3413; // 桌游棋牌
		//maxPage = 2016; // GMV
		//maxPage = 4510; // 音游
		//maxPage = 1553; // mugen
		maxPage = 3101;
		maxPage = 371;
		maxPage = 4427;
		maxPage = 9830;
		maxPage = 10328;
		maxPage = 20441;
		maxPage = 17698;
		String url = "https://api.bilibili.com/archive_rank/getarchiverankbypartion?tid=%d&pn=%d";
		//long timestamp = System.currentTimeMillis();
		// &_=1501928192983
		String sDir = "htmls/video/tid_" + tid + "/";
		File dir = new File(sDir);
		dir.mkdirs();
		for (int pn = 1; pn <= maxPage; pn++){
			String fullUrl = String.format(url, tid, pn);
			String content = HttpUtils.doGet(fullUrl, null, "utf-8");
			
			String fileName = sDir + pn + ".json";
			FileUtil.filePutContent(fileName, content, "utf-8");
			Thread.sleep(500);
			//break;
		}
	}
	
	

}
