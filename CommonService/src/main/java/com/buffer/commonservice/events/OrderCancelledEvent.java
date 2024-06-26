package com.buffer.commonservice.events;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCancelledEvent {
    private String orderId;
    private String orderStatus;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "OrderCancelledEvent [orderId=" + orderId + ", orderStatus=" + orderStatus + "]";
	}
	public OrderCancelledEvent(String orderId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}
	public OrderCancelledEvent() {
		super();
	}
	
}
