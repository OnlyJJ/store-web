package com.xy.sczl.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xy.sczl.common.utils.Page;
import com.xy.sczl.entity.ProductEntity;
import com.xy.sczl.service.ProductService;

/**
 * 产品相关控制器
 *
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    /**
     * 示例说明：
     * 	1、前端请求发起：http、jsp
     * 		http：
     * 			直接通过浏览器地址访问
     * 		jsp：
     * 			通过内部页面点击事件访问
     * 		两者的共同点：
     * 			都是需要controller进行匹配，如果在配置的扫描包下，所有的有@Controller注解的类，都没有匹配到请求的url，则抛出404异常
     * 
     * 	2、Model和 ModelAndView
     * 		相同点：
     * 			两者都是用于处理数据封装，返回给前端页面渲染，封装数据的方式都是Key-value形式，如：
     * 			Model使用addAttribute方法，ModelAndView使用addObject方法
     * 		不同点：
     * 			Model不需要设置绑定的返回页面地址；
     * 			ModelAndView需要手动设置，方法是setViewName
     * 	
     */
    
    @Autowired
    ProductService productService;

    /**
     * 获取产品列表
     * @param model 模型，用于封装响应地址及数据
     * @param request
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listProduct(ModelAndView model, HttpServletRequest request) {
    	// 封装page分页数据
    	Page<ProductEntity> page = new Page<ProductEntity>(request);
//      productService.findProducts(page);
    	page.setPageNo(1);
    	page.setPageSize(20);
    	page.setTotalCount(0);
    	page.setResult(new ArrayList<ProductEntity>());
    	
    	// 前端分页数据，必须使用page封装，否则解析失败
        model.addObject("page", page);
        // 绑定视图，（即返回到哪个页面）
    	model.setViewName("product/productList");
        return model;
    }

    /**
     * 商品详情
     * @param id 商品id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}")
    public String showInfo(@PathVariable Integer id, Model model) {
        ProductEntity product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/productView";
    }

}
