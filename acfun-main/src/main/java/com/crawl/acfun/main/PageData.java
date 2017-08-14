package com.crawl.acfun.main;

import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.JsonBean;

/**
 * Created by Administrator on 2017/6/26.
 */
public class PageData implements JsonBean{

    @JSONPath("$.page")
    private Page page;

    @Text
    @JSONPath("$.success")
    private Boolean success;

    @Text
    @JSONPath("$.html")
    private String html;
    
    @Text
    @JSONPath("$.list")
    private String list;

    
    //private List<Figure> dataList;

    public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

//    private List<Figure> figureList;
//    public List<Figure> getFigureList() {
//        if (figureList == null){
//            figureList = new ArrayList<Figure>();
//            Document doc = Jsoup.parseBodyFragment(html);
//            Elements resultLinks = doc.select("a");
//            for (Element ele: resultLinks){
//                Figure fig = new Figure();
//                //System.out.println(ele.attr("href"));
//                String href = ele.attr("href");
//                Element figure = ele.child(0);
//                int vid = Integer.parseInt(figure.attr("data-vid"));
//                String date = figure.attr("data-date");
//                String title = figure.attr("data-title");
//                String from = figure.attr("data-from");
//
//                Element img = figure.child(0);
//                String imgSrc = img.attr("src");
//
//                //Element figcations = figure.select("figcation").get(0);
//                Element viewEle = figure.select("figcation > p:nth-child(2) > span:nth-child(1) > span").get(0);
//                Integer view = parseInt(viewEle.text());
//
//                Element numEle = figure.select("figcation > p:nth-child(2) > span:nth-child(2) > span").get(0);
//                Integer danmu = parseInt(numEle.text());
//
//                fig.setUrl(href);
//                fig.setDanmu(danmu);
//                fig.setFrom(from);
//                fig.setImg(imgSrc);
//                fig.setTitle(title);
//                fig.setVid(vid);
//                fig.setViews(view);
//                figureList.add(fig);
//
//                //System.out.println(vid + "," + date + "," + title + ", " + view + ", " + num);
//            }
//        }
//        return figureList;
//    }

    private static int parseInt(String valStr){
        int pos = valStr.indexOf("万");
        if (pos > 0) {
            double val = Double.parseDouble(valStr.substring(0, pos));
            int ret = (int)(val * 10000);
            //System.out.println(valStr + ", " + ret + "\n");
            return ret;
        }
        return Integer.parseInt(valStr);
    }

//    public void setFigureList(List<Figure> figureList) {
//        this.figureList = figureList;
//    }
}
