package com.buffer.commonservice.events;

import com.buffer.commonservice.model.CardDetails;
import com.buffer.commonservice.model.TUser;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderShippedEvent {
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;
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
	public String getShipmentStatus() {
		return shipmentStatus;
	}
	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}
	@Override
	public String toString() {
		return "OrderShippedEvent [shipmentId=" + shipmentId + ", orderId=" + orderId + ", shipmentStatus="
				+ shipmentStatus + "]";
	}
	public OrderShippedEvent(String shipmentId, String orderId, String shipmentStatus) {
		super();
		this.shipmentId = shipmentId;
		this.orderId = orderId;
		this.shipmentStatus = shipmentStatus;
	}
	public OrderShippedEvent() {
		super();
	}
	
}
