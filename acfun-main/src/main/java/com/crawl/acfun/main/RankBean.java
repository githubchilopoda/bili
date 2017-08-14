package com.crawl.acfun.main;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HrefBean;
import com.geccocrawler.gecco.spider.HtmlBean;


/**
 * Created by Administrator on 2017/6/24.
 */

@Gecco(matchUrl="http://www.acfun.cn/rank/", pipelines={"consolePipeline", "saveCategoryPipeline"})
public class RankBean implements HtmlBean {

    private static final long serialVersionUID = -7127412585200687225L;  


    @Request
    private HttpRequest request;
    
    @HtmlField(cssPath = "div.mainer > h3 > a")
    private List<HrefBean> categoryList;
    
    @HtmlField(cssPath = "#guide-bar > div > div.l > a")
    private List<HrefBean> topCategoryList;

	public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<HrefBean> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<HrefBean> categoryList) {
		this.categoryList = categoryList;
	}

	public List<HrefBean> getTopCategoryList() {
		return topCategoryList;
	}

	public void setTopCategoryList(List<HrefBean> topCategoryList) {
		this.topCategoryList = topCategoryList;
	}

	public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		context.close();
    }
	//  游戏 / 本月 / 依点击数排序
	// http://www.acfun.cn/rank.aspx?channelId=60&range=1&count=30&ext=1&date=  娱乐排行榜
	// http://www.acfun.cn/rank.aspx?channelId=86&range=1&count=30&ext=1&date=  娱乐里边的生活娱乐排行榜
	// http://www.acfun.cn/rank.aspx?channelId=59&range=1&count=30&ext=1&date=  游戏排行榜 今日榜
	// http://www.acfun.cn/rank.aspx?channelId=59&range=2&count=30&ext=1&date=  游戏排行榜 本周榜
	// http://www.acfun.cn/rank.aspx?channelId=59&range=3&count=30&ext=1&date=  游戏排行榜 本月榜
}
