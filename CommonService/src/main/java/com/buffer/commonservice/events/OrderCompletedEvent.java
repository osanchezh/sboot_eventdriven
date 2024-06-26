package com.buffer.commonservice.events;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderCompletedEvent {
    @Override
	public String toString() {
		return "OrderCompletedEvent [orderId=" + orderId + ", orderStatus=" + orderStatus + "]";
	}
	public OrderCompletedEvent() {
		super();
	}
	public OrderCompletedEvent(String orderId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}
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
	private String orderId;
    private String orderStatus;
}