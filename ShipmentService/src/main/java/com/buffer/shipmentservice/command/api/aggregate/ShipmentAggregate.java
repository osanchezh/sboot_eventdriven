package com.buffer.shipmentservice.command.api.aggregate;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.buffer.commonservice.commands.ShipOrderCommand;
import com.buffer.commonservice.events.OrderShippedEvent;

@Aggregate
public class ShipmentAggregate {

    @AggregateIdentifier
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;

    public ShipmentAggregate() {
    }

    @CommandHandler
    public ShipmentAggregate(ShipOrderCommand shipOrderCommand) {
        //Validate the Command
        // Publish the Order Shipped event
        OrderShippedEvent orderShippedEvent
                = new OrderShippedEvent();
        orderShippedEvent.setShipmentId(shipOrderCommand.getShipmentId());
        orderShippedEvent.setOrderId(shipOrderCommand.getOrderId());
        orderShippedEvent.setShipmentStatus("COMPLETED");

        AggregateLifecycle.apply(orderShippedEvent);
    }

    @EventSourcingHandler
    public void on(OrderShippedEvent event) {
        this.orderId = event.getOrderId();
        this.shipmentId = event.getShipmentId();
        this.shipmentStatus = event.getShipmentStatus();
    }
}