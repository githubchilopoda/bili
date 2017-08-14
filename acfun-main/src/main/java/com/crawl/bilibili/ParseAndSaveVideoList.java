package com.crawl.bilibili;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.bili.dao.BiliFunDao;
import com.crawl.bili.entity.param.BiliFunParam;
import com.crawl.bili.entity.po.BiliFun;
import com.crawl.util.FileUtil;

public class ParseAndSaveVideoList {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		BiliFunDao<BiliFun, BiliFunParam> biliFunDao = context.getBean(BiliFunDao.class);
		String topDir = "F:\\develop\\acfun\\acfun-main\\htmls\\video";
		String processedDir = "F:\\develop\\acfun\\acfun-main\\processed\\video";
		String errorDir = "F:\\develop\\acfun\\acfun-main\\error\\video";
		
		File dir = new File(topDir);
		String types[] = dir.list();
		for (String type : types) {
			File subDir = new File(topDir + "\\" + type);

			String[] fnames = subDir.list();
			for (String fname : fnames) {
				File file = new File(topDir + "\\" + type, fname);
				new File(processedDir + "\\" + type).mkdirs();
				new File(errorDir + "\\" + type).mkdirs();
				
				Date lastModified = new Date(file.lastModified());
				String contents = FileUtil.getFileContents(file.getAbsolutePath(), "utf-8");
				try {
					JSONObject retData = new JSONObject(contents);
//					if (!retData.has("data")){
//						continue;
//					}
					JSONArray dataArray = retData.getJSONObject("data").getJSONArray("archives");
					List<BiliFun> dataList = new ArrayList<BiliFun>();
					for (int i = 0; i < dataArray.length(); i++) {
						JSONObject jsonObj = dataArray.getJSONObject(i);
						BiliFun biliFun = BiliFun.fromJson(jsonObj);
						biliFun.setCrawlTime(lastModified);
						// System.out.println(biliFun);
						// biliFunDao.insert(biliFun);
						// break;
						dataList.add(biliFun);
					}
					biliFunDao.insertBatch(dataList);
					file.renameTo(new File(processedDir + "\\" + type, fname));
				}catch (Exception ex){
					file.renameTo(new File(errorDir + "\\" + type, fname));
				}
				//break;
			}
			System.out.println("Done: " + type);
			//break;
		}

	}

}
