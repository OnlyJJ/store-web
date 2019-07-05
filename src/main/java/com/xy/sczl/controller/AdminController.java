package com.xy.sczl.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xy.sczl.common.constants.Constants;
import com.xy.sczl.common.constants.ErrorCode;
import com.xy.sczl.common.exception.BizException;
import com.xy.sczl.common.redis.RedisCache;
import com.xy.sczl.common.utils.AdminUtil;
import com.xy.sczl.common.utils.Image;
import com.xy.sczl.common.utils.Page;
import com.xy.sczl.entity.AdminEntity;
import com.xy.sczl.entity.PictureEntity;
import com.xy.sczl.entity.ProductEntity;

/**
 * 管理后台
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    
    @Resource
    RedisCache redisCache;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "admin/index";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String reg() {
        return "admin/adminReg";
    }
    
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String doReg(AdminEntity admin, HttpSession session) {
//        adminService.save(admin);
    	// 暂时使用缓存
    	String s = null;
    	s.toString();
    	redisCache.setString(admin.getUserId(), admin.getPassword());
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "admin/adminLogin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String doLogin(AdminEntity admin, HttpSession session) {
        if (redisCache.exits(admin.getUserId())) {
        	AdminUtil.saveAdminToSession(session, admin);
            logger.debug("管理员[{}]登陆成功",admin.getUsername());
            return "redirect:/admin/product";
        }
        return "redirect:/admin/login?errorPwd=true";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String doLogout(HttpSession session) {
        return "redirect:/";
    }

    /**
     * 产品列表
     * @param model
     * @param session
     * @param request
     * @return
     */
    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public ModelAndView admin(ModelAndView model, HttpSession session, HttpServletRequest request) {
        Page<ProductEntity> page = new Page<>(request);
        page.setPageNo(1);
        page.setPageSize(20);
        page.setResult(new ArrayList<ProductEntity>());
        page.setTotalCount(0);
//        productService.findProducts(page);
        
        model.addObject("page", page);
        model.setViewName("admin/product/productAdmin");
        return model;
    }

    /**
     * 上传商品页
     * @param session
     * @return
     */
    @RequestMapping(value = "/product/new", method = RequestMethod.GET)
    public String newForm(HttpSession session) {
        if (AdminUtil.getAdminFromSession(session) == null) {
            return "redirect:/admin/login?error=true";
        }
        return "admin/product/productNew";
    }

    /**
     * 上传商品
     * @param product
     * @param session
     * @param file
     * @return 上传后，返回到商品列表
     */
    @RequestMapping(value = "/product/new", method = RequestMethod.POST)
    public String doNew(ProductEntity product, HttpSession session, @RequestParam("imgFile") MultipartFile file) {
        if (file!=null&&!file.isEmpty()) {
            uploadImage(product, session, file);
        }
//        product.setCreateTime(new Date());
//        productService.save(product);
        return "redirect:/admin/product";
    }

    /**
     * 编辑商品页
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView model, @PathVariable Integer id) {
//    	PictureEntity product = productService.findById(id);
        model.addObject("product", new PictureEntity());
        model.setViewName("admin/product/productEdit");
        return model;
    }

    /**
     * 提交编辑
     * @param model
     * @param product
     * @param session
     * @param file
     * @return
     */
    @RequestMapping(value = "/product/edit", method = RequestMethod.POST)
    public ModelAndView doEdit(ModelAndView model, ProductEntity product, HttpSession session, @RequestParam(name = "file",required = false) MultipartFile file) {
        if (file!=null&&!file.isEmpty()) {
            uploadImage(product, session, file);
        }
//        productService.save(product);
        model.setViewName("redirect:/admin/product");
        return model;
    }

    private void uploadImage(ProductEntity product, HttpSession session, MultipartFile file) {
        String fileName = generateFileName();
        String path = generateFilePath(session);
        String serverFile = path + "/" + fileName;
        PictureEntity picture = uploadAndSaveImg(session, file, fileName, path, serverFile);
//        product.setMasterPic(picture);
    }

    private String generateFilePath(HttpSession session) {
        return session.getServletContext().getRealPath("/upload");
    }

    private String generateFileName() {
        return new Date().getTime() + ".jpg";
    }

    private PictureEntity uploadAndSaveImg(HttpSession session, MultipartFile file, String fileName, String path, String serverFile) {
    	PictureEntity picture = new PictureEntity();
        try {
            logger.info(path);
            if (!new File(path).exists()) {
                new File(path).mkdirs();
            }
            if (!new File(serverFile).exists()) {
                new File(serverFile).createNewFile();
            }
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(new File(serverFile)));
            stream.write(bytes);
            stream.close();
            //缩放处理
            Image image = new Image(serverFile);
            image.resize(Constants.IMG_WIDTH,Constants.IMG_HEIGHT);
            image.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        picture.setMemo("商品上传");
//        picture.setTitle("商品上传");
//        picture.setUpdateTime(new Date());
//        picture.setUrl("/upload/" + fileName);
//        picture.setUpdateAdmin(AdminUtil.getAdminFromSession(session));
//        pictureService.save(picture);
        return picture;
    }

}
