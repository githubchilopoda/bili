package com.crawl.acfun.main;

import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.spider.JsonBean;

/**
 * Created by Administrator on 2017/6/26.
 */
public class Page implements JsonBean{

    @JSONPath("$.pageNo")
    private Integer pageNo;

    @JSONPath("$.pageSize")
    private Integer pageSize;

    @JSONPath("$.totalCount")
    private Integer totalCount;

    @JSONPath("$.totalPage")
    private Integer totalPage;

    @JSONPath("$.prePage")
    private Integer prePage;

    @JSONPath("$.nextPage")
    private Integer nextPage;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPrePage() {
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
}
