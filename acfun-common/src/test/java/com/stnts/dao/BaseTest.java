package com.stnts.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crawl.acfun.dao.CategoryDao;
import com.crawl.acfun.dao.WebDao;
import com.crawl.acfun.entity.param.CategoryParam;
import com.crawl.acfun.entity.param.WebParam;
import com.crawl.acfun.entity.po.Category;
import com.crawl.acfun.entity.po.Web;



public class BaseTest {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring.xml");
	
	public static WebDao<Web, WebParam> webMapper = context.getBean(WebDao.class);
	public static CategoryDao<Category, CategoryParam> categoryDao = context.getBean(CategoryDao.class);
}
