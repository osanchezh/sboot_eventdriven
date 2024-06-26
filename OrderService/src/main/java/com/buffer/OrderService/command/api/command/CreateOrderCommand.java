package com.buffer.OrderService.command.api.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;


public class CreateOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;
	private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;
    public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "CreateOrderCommand [orderId=" + orderId + ", productId=" + productId + ", userId=" + userId
				+ ", addressId=" + addressId + ", quantity=" + quantity + ", orderStatus=" + orderStatus + "]";
	}
	public CreateOrderCommand() {
		super();
	}
	public CreateOrderCommand(String orderId, String productId, String userId, String addressId, Integer quantity,
			String orderStatus) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.userId = userId;
		this.addressId = addressId;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
	}

}