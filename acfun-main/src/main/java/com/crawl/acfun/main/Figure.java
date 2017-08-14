package com.crawl.acfun.main;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.Date;

/**
 * Created by Administrator on 2017/6/27.
 */
public class Figure  implements HtmlBean{

    @Attr("href")
    @HtmlField(cssPath="a")
    private String url;

    @Attr("data-vid")
    @HtmlField(cssPath="a:nth-child(1) > figure")
    private Integer vid;

 //   private Date date;

    @Attr("data-title")
    @HtmlField(cssPath="a:nth-child(1) > figure")
    private String title;

    @Attr("data-from")
    @HtmlField(cssPath="a:nth-child(1) > figure")
    private String from;

    @Attr("src")
    @HtmlField(cssPath="a:nth-child(1) > figure > img")
    private String img; // 可能要下载

    @Text
    @HtmlField(cssPath="a:nth-child(1) > figure > figcation > p:nth-child(2) > span:nth-child(1) > span")
    private Integer views;

    @Text
    @HtmlField(cssPath="a:nth-child(1) > figure > figcation > p:nth-child(2) > span:nth-child(2) > span")
    private Integer danmu; // 弹幕

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getDanmu() {
        return danmu;
    }

    public void setDanmu(Integer danmu) {
        this.danmu = danmu;
    }
}
