package com.buffer.commonservice.commands;

import java.util.Objects;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelOrderCommand {

    @TargetAggregateIdentifier
    private String orderId;
    private String orderStatus = "CANCELLED";
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
		return "CancelOrderCommand [orderId=" + orderId + ", orderStatus=" + orderStatus + "]";
	}
	public CancelOrderCommand(String orderId, String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
	}
	public CancelOrderCommand(String orderId) {
		super();
		this.orderId = orderId;
	}
	public CancelOrderCommand() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderId, orderStatus);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CancelOrderCommand other = (CancelOrderCommand) obj;
		return Objects.equals(orderId, other.orderId) && Objects.equals(orderStatus, other.orderStatus);
	}
	
}
