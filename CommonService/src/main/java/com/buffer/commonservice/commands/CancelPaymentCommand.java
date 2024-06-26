package com.buffer.commonservice.commands;

import java.util.Objects;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class CancelPaymentCommand {
    @TargetAggregateIdentifier
    private String paymentId;
    private String orderId;
    private String paymentStatus = "CANCELLED";
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
		return "CancelPaymentCommand [paymentId=" + paymentId + ", orderId=" + orderId + ", paymentStatus="
				+ paymentStatus + "]";
	}
	public CancelPaymentCommand(String paymentId, String orderId, String paymentStatus) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.paymentStatus = paymentStatus;
	}
	public CancelPaymentCommand(String paymentId, String orderId) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
	}
	public CancelPaymentCommand() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderId, paymentId, paymentStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CancelPaymentCommand other = (CancelPaymentCommand) obj;
		return Objects.equals(orderId, other.orderId) && Objects.equals(paymentId, other.paymentId)
				&& Objects.equals(paymentStatus, other.paymentStatus);
	}
	
}
