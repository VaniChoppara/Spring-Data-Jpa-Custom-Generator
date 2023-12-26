package com.app.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ORDER_DTLS")
public class OrderDetails {
	@Id
	@GenericGenerator(name="order_id_gen", type=com.app.generator.OrderIdCustomGenerator.class)
	@GeneratedValue(generator="order_id_gen")
	@Column(name="order_id")
	String orderId;
	String orderName;
	Integer orderQty;
	Double orderPrice;
	
	public OrderDetails() {
	}

	public OrderDetails(String orderId, String orderName, Integer orderQty, Double orderPrice) {
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderQty = orderQty;
		this.orderPrice = orderPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Integer getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(Integer orderQty) {
		this.orderQty = orderQty;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderName=" + orderName + ", orderQty=" + orderQty
				+ ", orderPrice=" + orderPrice + "]";
	}

	
}
 