package com.xy.sczl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 首页
 */
@Controller
@RequestMapping("/")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
//	@Autowired
//	ProductService productService;

	/**
	 * 默认的首页
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {
		// ModelAndView是前端数据模型，用于封装controller返回的数据，包括：
		// 1、指定返回到的页面（即返回到哪里）
		// 2、返回什么（即数据，前面是key，后面是具体的数据，前端页面从key中取值）
		model = new ModelAndView();
		model.setViewName("index");
		// 数据模型
//		model.addObject("newProductList", productService.findNew());
//		model.addObject("popProductList", productService.findPop());
//		model.addObject("productList", productService.findAll());
//		model.addObject("productTypeList", productService.findType());
		return model;
	}

}
