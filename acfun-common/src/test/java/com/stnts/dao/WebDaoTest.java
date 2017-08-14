package com.stnts.dao;

import java.util.List;

import org.junit.Test;

import com.crawl.acfun.entity.param.WebParam;
import com.crawl.acfun.entity.po.Category;
import com.crawl.acfun.entity.po.Web;

public class WebDaoTest extends BaseTest {

	@Test
	public void add() {
		
		String names[] = {"bilibili", "douyu", "weibo", "webchat"};
		String urls[]= {"https://www.bilibili.com/", "https://www.douyu.com/", "http://weibo.com/", "http://wx.qq.com/"};
//		Web web = new Web();
//		web.setWebid(1);
//		web.setName("acfun");
//		web.setUrl("http://www.acfun.cn");
		
		for (int i = 0; i < names.length; i++){
			Web web = new Web();
			web.setWebId(i + 2);
			web.setName(names[i]);
			web.setUrl(urls[i]);			
			try {
				Integer ret = webMapper.insert(web);
				System.out.println("isInsert: " + ret);
			} catch (Exception e) {
				System.out.println("插入账号异常" + e);
			}
		}
		
	}
	
	@Test
	public void getWebById() {

		try {
			Web web = webMapper.selectByPrimaryKey(1);
			System.out.println("name: " + web.getName());
			System.out.println("url: " + web.getUrl());
		} catch (Exception e) {
			System.out.println("查询异常" + e);
		}
	}
	
	@Test
	public void getWebList() {

		try {
			WebParam webParam = new WebParam();
			List<Web> webList = webMapper.selectList(webParam);
			for(Web web:webList){
				System.out.println("++++++++++++++++++++++++++++++++++++++");
				System.out.println("name: " + web.getName());
				System.out.println("url: " + web.getUrl());
				System.out.println("++++++++++++++++++++++++++++++++++++++");
			}
		} catch (Exception e) {
			System.out.println("插入账号异常" + e);
		}
	}
	
	@Test
	public void fillFunVideo(){
		// http://www.acfun.cn/bangumi/bangumi/page?pageSize=42&isWeb=1&pageNo=2&sort=1
		
		for (int i = 1; i <= 9; i++){
			String url = "http://www.acfun.cn/bangumi/bangumi/page?pageSize=42&isWeb=1&pageNo=" + i + "&sort=1";
			//Url url = new Url(url);		
		}
	}
	
	@Test
	public void getCategoryList(){
		List<Category> categoryList = categoryDao.getCategoryList(false);
		for (Category category: categoryList){
			System.out.println(category.getName() + ", " + category.getPid());
		}
	}
}
