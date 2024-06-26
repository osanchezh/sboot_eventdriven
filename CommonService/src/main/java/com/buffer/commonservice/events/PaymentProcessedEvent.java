package com.buffer.commonservice.events;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentProcessedEvent {
    private String paymentId;
    private String orderId;
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
	@Override
	public String toString() {
		return "PaymentProcessedEvent [paymentId=" + paymentId + ", orderId=" + orderId + "]";
	}
	public PaymentProcessedEvent(String paymentId, String orderId) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
	}
	public PaymentProcessedEvent() {
		super();
	}
	
	
}