package com.crawl.bili.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crawl.bili.entity.param.BiliVideoParam;
import com.crawl.bili.entity.po.BiliVideo;
import com.crawl.bili.entity.vo.PaginationResult;
import com.crawl.bili.service.BiliVideoService;



/**
 * 
 *  控制层
 * 
 */
@Controller
public class BiliVideoController{

	@Resource
	private BiliVideoService biliVideoService;

	/**
	 * 
	 * 分页查询方法
	 * 
	 */
	@RequestMapping("/findListByPage.do")
	public ModelAndView  findListByPage(BiliVideoParam param) {
		ModelAndView view = new ModelAndView("/page/biliVideoList");
		PaginationResult<BiliVideo> result = this.biliVideoService.findListByPage(param);
		view.addObject("result", result);
		return view;
	}
}