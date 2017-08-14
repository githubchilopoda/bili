package com.crawl.bilibili;

import com.crawl.util.HttpUtils;

public class UserVideoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int uid = 546195;
		String url =
		"https://space.bilibili.com/ajax/member/getSubmitVideos?mid=546195&pagesize=30&tid=0&page=1&keyword=&order=pubdate";

//		String url = "https://space.bilibili.com/ajax/member/GetInfo";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("mid", "" + uid);
//		params.put("csrf", "");
//		String contents = HttpUtils.doPost(url, params, "utf-8");
		//System.out.println(contents);
		
		//url = "https://space.bilibili.com/ajax/member/getSubmitVideos?mid=546195&page=1&pagesize=25";
		String contents = HttpUtils.doGet(url, null, "utf-8");
		System.out.println(contents);
	}

}
