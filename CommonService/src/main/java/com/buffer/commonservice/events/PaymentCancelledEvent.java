package com.buffer.commonservice.events;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentCancelledEvent {
    private String paymentId;
    private String orderId;
    private String paymentStatus;
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "PaymentCancelledEvent [paymentId=" + paymentId + ", orderId=" + orderId + ", paymentStatus="
				+ paymentStatus + "]";
	}
	public PaymentCancelledEvent(String paymentId, String orderId, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.paymentStatus = paymentStatus;
	}
	public PaymentCancelledEvent() {
		super();
	}
	
	
}
