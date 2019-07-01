/**
 * 
 */
package com.xy.sczl.entity;

import java.io.Serializable;

/**
 * 订单关联明细
 * 
 */
public class OrderItem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private ProductEntity product;//关联商品
	private Order order;//关联订单
	private Integer quantity;//关联数量

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
