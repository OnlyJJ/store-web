package com.xy.sczl.model.result;

import java.math.BigDecimal;

public class ProductInfo {
	
	private String productId;
    /**
     * 	商品名称
     */
    private String title;
    /**
     * 	商品价格
     */
    private BigDecimal point;
    /**
     * 	商品编码
     */
    private String code;
    /**
     * 	商品型号
     */
    private String model;
    /**
     * 	商品库存
     */
    private Integer stock;
    /**
     * 	商品图片路径
     */
    private String imgFile;
    /**
     * 	商品介绍
     */
    private String note;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPoint() {
		return point;
	}
	public void setPoint(BigDecimal point) {
		this.point = point;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
    
}
