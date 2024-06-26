package com.buffer.paymentservice.command.api.data;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {

    @Id
    private String paymentId;
    private String orderId;
    private Date timeStamp;
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
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", orderId=" + orderId + ", timeStamp=" + timeStamp
				+ ", paymentStatus=" + paymentStatus + "]";
	}
	public Payment(String paymentId, String orderId, Date timeStamp, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.timeStamp = timeStamp;
		this.paymentStatus = paymentStatus;
	}
	public Payment() {
		super();
	}
	
}