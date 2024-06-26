package com.buffer.shipmentservice.command.api.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Shipment {

    @Id
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
		return "Shipment [shipmentId=" + shipmentId + ", orderId=" + orderId + ", shipmentStatus=" + shipmentStatus
				+ "]";
	}
	public Shipment(String shipmentId, String orderId, String shipmentStatus) {
		super();
		this.shipmentId = shipmentId;
		this.orderId = orderId;
		this.shipmentStatus = shipmentStatus;
	}
	public Shipment() {
		super();
	}
	
}