package com.buffer.commonservice.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ValidatePaymentCommand {

    @TargetAggregateIdentifier
    private String paymentId;
    private String orderId;
    private CardDetails cardDetails;
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
	public CardDetails getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}
	@Override
	public String toString() {
		return "ValidatePaymentCommand [paymentId=" + paymentId + ", orderId=" + orderId + ", cardDetails="
				+ cardDetails + "]";
	}
	public ValidatePaymentCommand(String paymentId, String orderId, CardDetails cardDetails) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.cardDetails = cardDetails;
	}
	public ValidatePaymentCommand() {
		super();
	}
	
}