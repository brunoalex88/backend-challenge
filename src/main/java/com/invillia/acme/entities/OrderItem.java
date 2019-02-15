package com.invillia.acme.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TB_ORDER_ITEM")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ORDER_ITEM_DESCRIPTION")
	private String description;
	
	@Column(name = "ORDER_ITEM_PRICE")
	private BigDecimal price;
	
	@Column(name = "ORDER_ITEM_QUANTITY")
	private Long quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	private Order order;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
}
