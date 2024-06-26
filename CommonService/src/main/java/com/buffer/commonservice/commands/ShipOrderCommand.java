package com.buffer.commonservice.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShipOrderCommand {

    @TargetAggregateIdentifier
    private String shipmentId;
    private String orderId;
	public String getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "ShipOrderCommand [shipmentId=" + shipmentId + ", orderId=" + orderId + "]";
	}
	public ShipOrderCommand(String shipmentId, String orderId) {
		super();
		this.shipmentId = shipmentId;
		this.orderId = orderId;
	}
	public ShipOrderCommand() {
		super();
	}
	
}
