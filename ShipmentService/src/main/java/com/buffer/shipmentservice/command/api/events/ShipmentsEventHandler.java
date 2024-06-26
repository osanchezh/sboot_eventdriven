package com.buffer.shipmentservice.command.api.events;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.buffer.commonservice.events.OrderShippedEvent;
import com.buffer.shipmentservice.command.api.data.Shipment;
import com.buffer.shipmentservice.command.api.data.ShipmentRepository;

@Component
public class ShipmentsEventHandler {

    private ShipmentRepository shipmentRepository;

    public ShipmentsEventHandler(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @EventHandler
    public void on(OrderShippedEvent event) {
        Shipment shipment
                = new Shipment();
        BeanUtils.copyProperties(event,shipment);
        shipmentRepository.save(shipment);
    }
}