package com.crawl.acfun.main;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.*;

import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.JsonBean;

/**
 * Created by Administrator on 2017/6/24.
 */

@Gecco(matchUrl="http://www.acfun.cn/bangumi/bangumi/page?pageSize=42&isWeb=1&pageNo={pageNo}&sort=1", pipelines={"consolePipeline" /*, "pagePipeline" */})
public class AcfunVideoPage implements JsonBean {

    private static final long serialVersionUID = -7127412585200687225L;

    @RequestParameter("sort")
    private String sort;

    @RequestParameter("pageNo")
    private Integer pageNo;
    
    @JSONPath("$.status")
    private Integer status;

    @JSONPath("$.success")
    private Integer errno;

    @Text
    @JSONPath("$.msg")
    private String errmsg;

    @JSONPath("$.data")
    private PageData pageData;

    @Request
    private HttpRequest request;

    public String getUrl(){
        return String.format("http://www.acfun.cn/bangumi/bangumi/page?pageSize=42&isWeb=1&pageNo=%d&sort=1", pageNo);
    }

    

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public PageData getPageData() {
        return pageData;
    }

    public void setPageData(PageData pageData) {
        this.pageData = pageData;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }
    
    

    public String getSort() {
		return sort;
	}



	public void setSort(String sort) {
		this.sort = sort;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public static void main(String[] args) {
        String url = "http://www.acfun.cn/bangumi/bangumi/page?pageSize=42&isWeb=1&pageNo=2&sort=1";
        //String url = "http://www.acfun.cn/space/next?uid=283459&type=video&orderBy=2&pageNo=2";
        GeccoEngine.create()
                //Gecco搜索的包路径
                .classpath("com.crawl.acfun.main")
                //开始抓取的页面地址
                .start(url)
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                .start();
    }
}
