package com.crawl.bili.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crawl.bili.entity.param.BiliFunParam;
import com.crawl.bili.entity.po.BiliFun;
import com.crawl.bili.entity.vo.PaginationResult;
import com.crawl.bili.service.BiliFunService;



/**
 * 
 *  控制层
 * 
 */
@Controller
public class BiliFunController{

	@Resource
	private BiliFunService biliFunService;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	@RequestMapping("/findListByPage.do")
	public ModelAndView  findListByPage(BiliFunParam param) {
		ModelAndView view = new ModelAndView("/page/biliFunList");
		PaginationResult<BiliFun> result = this.biliFunService.findListByPage(param);
		view.addObject("result", result);
		return view;
	}
}