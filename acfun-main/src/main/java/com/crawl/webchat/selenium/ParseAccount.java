package com.crawl.webchat.selenium;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.util.DateUtil;
import com.crawl.util.StringUtils;
import com.crawl.webchat.dao.NewRankDayDao;
import com.crawl.webchat.dao.WxAccountDao;
import com.crawl.webchat.dao.WxArticleDao;
import com.crawl.webchat.entity.param.NewRankDayParam;
import com.crawl.webchat.entity.param.WxAccountParam;
import com.crawl.webchat.entity.param.WxArticleParam;
import com.crawl.webchat.entity.po.NewRankDay;
import com.crawl.webchat.entity.po.WxAccount;
import com.crawl.webchat.entity.po.WxArticle;

public class ParseAccount {

	public static void main(String[] args) throws Exception {
		// System.out.println(App.parseInt("46万+"));
		//parseFile("tancaijing-2017-07-12.html");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
		WxAccountDao<WxAccount, WxAccountParam> wxAccountDao = context.getBean(WxAccountDao.class);
		WxArticleDao<WxArticle, WxArticleParam> wxArticleDao = context.getBean(WxArticleDao.class);
		
		Date now = new Date();
		String dayStr = DateUtil.formatDate(now);
		String dir = "html/author/" + dayStr;
		File folder = new File(dir);
		String fileNames[] = folder.list();
		for (String fileName: fileNames){
			//int pos = fileName.lastIndexOf(".");
			//String account = fileName.substring(0, pos);
			if (!fileName.contains("daaimaomikong")){
				continue;
			}
			parseFile(dir + "/" + fileName, wxAccountDao, wxArticleDao);
			
			
		}
	}

	public static void parseFile(String fileName, WxAccountDao<WxAccount, WxAccountParam> wxAccountDao,
			WxArticleDao<WxArticle, WxArticleParam> wxArticleDao) throws Exception {
		// "时事-2017-07-12.html"
		Document doc = Jsoup.parse(new File(fileName), "utf-8");

		// .info-detail-head-weixin-name > span:nth-child(1)

		String accountName = doc.select(".info-detail-head-weixin-name > span:nth-child(1)").get(0).text();
		String account = doc.select(".info-detail-head-weixin-account > span:nth-child(1)").get(0).text();
		account = account.substring(account.indexOf("：") + 1);

		String authority = doc.select(".info-detail-head-weixin-approve > span:nth-child(1)").get(0).text();
		authority = authority.substring(authority.indexOf("：") + 1);
		String introduction = doc.select(".info-detail-head-weixin-fun-introduce").get(0).text();
		introduction = introduction.substring(introduction.indexOf("：") + 1);

		String fansNumCap = doc.select(".detail-fans-counts").get(0).text();

		String capLink = doc.select("#info_detail_head_classify_type").get(0).text();
		String joinAt = doc.select(".info-detail-head-fans > div:nth-child(3) > span:nth-child(1)").get(0).text();

		Elements tagElements = doc.select("a.detail-tag-name");
		List<String> tagList = new ArrayList<String>();
		for (Element ele : tagElements) {
			tagList.add(ele.text());
		}

		String rankStr = doc.select(".info-detail-rank-indexing-rank-mc > span:nth-child(1)").get(0).text();
		String zhishuStr = doc.select(".info-detail-rank-indexing-rank-num > span:nth-child(1)").get(0).text();
		String rankDayStr = doc.select(".info-detail-rank-indexing-rank-date > span:nth-child(1)").get(0).text();

		String topZhishuStr = doc.select("#info_detail_rank_max_index_num").get(0).text();
		String topZhishuDayStr = doc.select("#info_detail_rank_max_index_date").get(0).text();

		String topRankStr = doc.select("#info_detail_rank_max_rank_num").get(0).text();
		topRankStr = topRankStr.substring(1, topRankStr.length() - 1);

		String topRankDayStr = doc.select("#info_detail_rank_max_rank_date").get(0).text();

		WxAccount wxAccount = new WxAccount();
		wxAccount.setAccount(account);
		wxAccount.setAccountName(accountName);
		wxAccount.setAuthority(authority);
		wxAccount.setCategoryName(capLink);
		wxAccount.setFanNum(StringUtils.parseInt(fansNumCap));
		wxAccount.setIntroduction(introduction);
		wxAccount.setJoinAt(DateUtil.parseDate(joinAt));

		wxAccount.setRank(StringUtils.parseInt(rankStr.substring(1, rankStr.length() - 1)));
		wxAccount.setZhishu(StringUtils.parseInt(zhishuStr));
		wxAccount.setRankDay(DateUtil.parseChineseDate(rankDayStr));

		wxAccount.setTags(StringUtil.join(tagList, ","));

		wxAccount.setTopRank(StringUtils.parseInt(topRankStr));
		wxAccount.setTopRankDay(DateUtil.parseDate(topRankDayStr));

		wxAccount.setTopZhishu(StringUtils.parseInt(topZhishuStr));
		wxAccount.setTopZhishuDay(DateUtil.parseDate(topZhishuDayStr));

		wxAccountDao.insert(wxAccount);
		//System.out.println(wxAccount);
		

		for (int i = 1; i <= 10; i++) {
			// #info_detail_article_top > li:nth-child(1) > p:nth-child(1) > a
			Element articleElement = doc.select("#info_detail_article_top > li:nth-child(" + i + ")").get(0);
			if (articleElement == null) {
				continue;
			}
			WxArticle article = parseFromElement(articleElement);
			article.setAuthor(account);
			wxArticleDao.insert(article);
			System.out.println(article);
		}

		for (int i = 1; i <= 10; i++) {
			// #info_detail_article_lastest > li:nth-child(1) > p.title > a
			Element articleElement = doc.select("#info_detail_article_lastest > li:nth-child(" + i + ")").get(0);
			if (articleElement == null) {
				continue;
			}
			WxArticle article = parseFromElement(articleElement);
			article.setAuthor(account);
			wxArticleDao.insert(article);
			System.out.println(article);
		}
	}

	public static WxArticle parseFromElement(Element articleElement) {
		WxArticle article = new WxArticle();

		Element ele = articleElement.select("p:nth-child(1) > a").get(0);
		String url = ele.attr("href");
		String title = ele.text();

		String queryStr = url.substring(url.indexOf("?") + 1);
		queryStr = queryStr.replace("==", "");
		String parts[] = queryStr.split("&");
		for (String part : parts) {
			String keyValue[] = part.split("=");
			if (keyValue[0].equals("__biz")) {
				// article.setAuthor(author);
				article.setBiz(keyValue[1]);
				article.setBizDecoded(StringUtils.base64Decode(keyValue[1]));
				// article.setDescription(description);

			} else if (keyValue[0].equals("idx")) {
				article.setIdx(StringUtils.parseInt(keyValue[1]));
			} else if (keyValue[0].equals("mid")) {
				article.setMid(StringUtils.parseLong(keyValue[1]));
			} else if (keyValue[0].equals("sn")) {
				article.setSn(keyValue[1]);
			}
		}
		String pubDateStr = articleElement.select("p.tj > span.info-detail-article-date").get(0).text();
		String viewNumberStr = articleElement.select("p.tj > span.read > span.read-count").get(0).text();
		String starNumberStr = articleElement.select("p.tj > span.read > span.image > span").get(0).text();
		String description = articleElement.select("p.article-text > a").get(0).text();

		article.setTitle(title);
		// article.setAuthor(account);
		article.setDescription(description);
		// article.setLevel(level);
		article.setPublishTime(DateUtil.parseDateTime(pubDateStr));
		article.setStarNumber(StringUtils.parseInt(starNumberStr));
		article.setViewNumber(StringUtils.parseInt(viewNumberStr));
		return article;
	}

	public static NewRankDay parseFromRow(Element row) {
		Element link = row.select("td:nth-child(2) > div > h4 > a").get(0);
		Element fabu = row.select("td:nth-child(3)").get(0);
		Element zongyuedu = row.select("td:nth-child(4)").get(0);

		Element toutiao = row.select("td:nth-child(5)").get(0);
		Element pingjun = row.select("td:nth-child(6)").get(0);

		Element zuigao = row.select("td:nth-child(7)").get(0);
		Element dianzhan = row.select("td:nth-child(8)").get(0);

		Element zishu = row.select("td:nth-child(9)").get(0);

		String href = link.attr("href");
		int pos = href.indexOf("=");
		String account = href.substring(pos + 1);

		NewRankDay rankDay = new NewRankDay();
		rankDay.setAccount(account);
		rankDay.setAccountName(link.attr("title"));
		rankDay.setCategoryName("时事");
		rankDay.setDay(new Date());
		rankDay.setDianzhan(StringUtils.parseInt(dianzhan.text()));

		String parts[] = fabu.text().split("/");
		rankDay.setFabu1(Integer.parseInt(parts[0]));
		rankDay.setFabu2(Integer.parseInt(parts[1]));

		rankDay.setPingjun(StringUtils.parseInt(pingjun.text()));
		// rankDay.setRank(i);
		rankDay.setToutiao(StringUtils.parseInt(toutiao.text()));
		rankDay.setZishu(Double.parseDouble(zishu.text()));
		rankDay.setZongyuedu(StringUtils.parseInt(zongyuedu.text()));
		rankDay.setZuigao(StringUtils.parseInt(zuigao.text()));
		return rankDay;
	}
}
