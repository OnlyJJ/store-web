/**
 *
 */
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

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listProduct(ModelAndView model, HttpServletRequest request) {
    	 Page<ProductEntity> page = new Page<ProductEntity>(request);
//         productService.findProducts(page);
    	 page.setPageNo(1);
    	 page.setPageSize(20);
    	 page.setTotalCount(0);
    	 page.setResult(new ArrayList<ProductEntity>());
    	 
         model.addObject("page", page);
    	model.setViewName("product/productList");
        return model;
    }

    @RequestMapping(value = "/{id}")
    public String showInfo(@PathVariable Integer id, Model model) {
        ProductEntity product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/productView";
    }


}
