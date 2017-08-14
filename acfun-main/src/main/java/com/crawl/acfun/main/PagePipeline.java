package com.crawl.acfun.main;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;

/**
 * Created by Administrator on 2017/6/30.
 */
@PipelineName("pagePipeline")
public class PagePipeline  implements Pipeline<Acfun> {

    @Override
    public void process(Acfun bean) {
        // 保存当前页爬取的图片信息
    	
    	


        //继续抓取下一页构造下一页
//        int currPage = bean.getPageNo();
//        int totalPage = bean.getPageData().getPage().getTotalPage();
//        if (currPage < totalPage) {
//            int nextPage = currPage + 1;
//
//            String nextUrl = bean.getUrl().replace("pageNo=" + currPage, "pageNo=" + nextPage);
//            HttpRequest request = bean.getRequest();
//            SchedulerContext.into(request.subRequest(nextUrl));
//        }
    }
}
