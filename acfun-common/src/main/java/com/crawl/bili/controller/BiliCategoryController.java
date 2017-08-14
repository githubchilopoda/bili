package com.crawl.bili.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crawl.bili.entity.param.BiliCategoryParam;
import com.crawl.bili.entity.po.BiliCategory;
import com.crawl.bili.entity.vo.PaginationResult;
import com.crawl.bili.service.BiliCategoryService;



/**
 * 
 *  控制层
 * 
 */
@Controller
public class BiliCategoryController{

	@Resource
	private BiliCategoryService biliCategoryService;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	@RequestMapping("/findListByPage.do")
	public ModelAndView  findListByPage(BiliCategoryParam param) {
		ModelAndView view = new ModelAndView("/page/biliCategoryList");
		PaginationResult<BiliCategory> result = this.biliCategoryService.findListByPage(param);
		view.addObject("result", result);
		return view;
	}
}