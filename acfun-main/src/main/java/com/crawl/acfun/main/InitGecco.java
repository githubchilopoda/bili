//package com.crawl.acfun.main;
//
//import org.springframework.stereotype.Service;
//
//import com.geccocrawler.gecco.GeccoEngine;
//import com.geccocrawler.gecco.spring.SpringGeccoEngine;
//
//@Service
//public class InitGecco extends SpringGeccoEngine {
//
//	@Override
//	public void init() {
//		String url = "http://www.acfun.cn/u/1484578.aspx";
//		// String url =
//		// "http://www.acfun.cn/space/next?uid=283459&type=video&orderBy=2&pageNo=2";
//		GeccoEngine.create()
//				// Gecco搜索的包路径
//				.classpath("com.crawl.acfun.main")
//				// 开始抓取的页面地址
//				.start(url)
//				// 开启几个爬虫线程
//				.thread(1)
//				// 单个爬虫每次抓取完一个请求后的间隔时间
//				.interval(2000).start();
//	}
//
//}
