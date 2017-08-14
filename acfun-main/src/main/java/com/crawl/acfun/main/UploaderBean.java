package com.crawl.acfun.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.pipeline.PipelineFactory;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;


/**
 * Created by Administrator on 2017/6/24.
 */

@Gecco(matchUrl="http://www.acfun.cn/u/{uid}.aspx", pipelines={"consolePipeline", "uploaderPipeline"})
public class UploaderBean implements HtmlBean {

    private static final long serialVersionUID = -7127412585200687225L;

    @RequestParameter("uid")
    private Integer uid; 


    @HtmlField(cssPath = "#main > script")
    private String jsScript;

    @Request
    private HttpRequest request;

    public String getUrl(){
        return String.format("http://www.acfun.cn/u/%d.aspx#page=1", uid);
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }  


    public String getJsScript() {
		return jsScript;
	}

	public void setJsScript(String jsScript) {
		this.jsScript = jsScript;
	}

	public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public static void main(String[] args) {
    	//String url = "http://www.acfun.cn/u/1155262.aspx";
    	//String url = "http://www.acfun.cn/rank/";
    	String url = "http://www.acfun.cn/bangumi/bangumi/page?pageSize=42&isWeb=1&pageNo=2&sort=1";
    	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring.xml");
		
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		PipelineFactory springPipelineFactory = (PipelineFactory) ctx.getBean("springPipelineFactory");
		GeccoEngine.create()
				.pipelineFactory(springPipelineFactory)
				.classpath("com.crawl.acfun.main")
				.start(url)
				.run();
        
        
        try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ctx.close();
    }
}
