package com.buffer.OrderService.command.api.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.buffer.OrderService.command.api.events.OrderCreatedEvent;
import com.buffer.commonservice.commands.CancelOrderCommand;
import com.buffer.commonservice.commands.CancelPaymentCommand;
import com.buffer.commonservice.commands.CompleteOrderCommand;
import com.buffer.commonservice.commands.ShipOrderCommand;
import com.buffer.commonservice.commands.ValidatePaymentCommand;
import com.buffer.commonservice.events.OrderCancelledEvent;
import com.buffer.commonservice.events.OrderCompletedEvent;
import com.buffer.commonservice.events.OrderShippedEvent;
import com.buffer.commonservice.events.PaymentCancelledEvent;
import com.buffer.commonservice.events.PaymentProcessedEvent;
import com.buffer.commonservice.model.TUser;
import com.buffer.commonservice.queries.GetUserPaymentDetailsQuery;

import java.util.UUID;

@Saga
public class OrderProcessingSaga {
	private final Logger LOGGER = LoggerFactory.getLogger(OrderProcessingSaga.class);
    @Autowired
    private transient CommandGateway commandGateway;

    @Autowired
    private transient QueryGateway queryGateway;


    public OrderProcessingSaga() {
    }

    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    private void handle(OrderCreatedEvent event) {
    	LOGGER.info("OrderCreatedEvent in Saga for Order Id : {}",
                event.getOrderId());

        GetUserPaymentDetailsQuery getUserPaymentDetailsQuery
                = new GetUserPaymentDetailsQuery(event.getUserId());

        TUser user = null;

        try {
            user = queryGateway.query(
                    getUserPaymentDetailsQuery,
                    ResponseTypes.instanceOf(TUser.class)
            ).join();

        } catch (Exception e) {
        	LOGGER.error(e.getMessage());
            //Start the Compensating transaction
            cancelOrderCommand(event.getOrderId());
        }

        ValidatePaymentCommand validatePaymentCommand
                = new ValidatePaymentCommand();
        validatePaymentCommand.setCardDetails(user.getCardDetails());
        validatePaymentCommand.setOrderId(event.getOrderId());
        validatePaymentCommand.setPaymentId(UUID.randomUUID().toString());

        commandGateway.sendAndWait(validatePaymentCommand);
    }

    private void cancelOrderCommand(String orderId) {
        CancelOrderCommand cancelOrderCommand
                = new CancelOrderCommand(orderId);
        commandGateway.send(cancelOrderCommand);
    }

    @SagaEventHandler(associationProperty = "orderId")
    private void handle(PaymentProcessedEvent event) {
    	LOGGER.info("PaymentProcessedEvent in Saga for Order Id : {}",
                event.getOrderId());
        try {

            //if(true)
              //  throw new Exception();

            ShipOrderCommand shipOrderCommand
                    = new ShipOrderCommand();
            shipOrderCommand.setShipmentId(UUID.randomUUID().toString());
            shipOrderCommand.setOrderId(event.getOrderId());
            commandGateway.send(shipOrderCommand);
        } catch (Exception e) {
        	LOGGER.error(e.getMessage());
            // Start the compensating transaction
            cancelPaymentCommand(event);
        }
    }

    private void cancelPaymentCommand(PaymentProcessedEvent event) {
        CancelPaymentCommand cancelPaymentCommand
                = new CancelPaymentCommand(
                event.getPaymentId(), event.getOrderId()
        );

        commandGateway.send(cancelPaymentCommand);
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(OrderShippedEvent event) {

    	LOGGER.info("OrderShippedEvent in Saga for Order Id : {}",
                event.getOrderId());

        CompleteOrderCommand completeOrderCommand
                = new CompleteOrderCommand();
        completeOrderCommand.setOrderId(event.getOrderId());
        completeOrderCommand.setOrderStatus("APPROVED");

        commandGateway.send(completeOrderCommand);
    }

    @SagaEventHandler(associationProperty = "orderId")
    @EndSaga
    public void handle(OrderCompletedEvent event) {
    	LOGGER.info("OrderCompletedEvent in Saga for Order Id : {}",
                event.getOrderId());
    }

    @SagaEventHandler(associationProperty = "orderId")
    @EndSaga
    public void handle(OrderCancelledEvent event) {
    	LOGGER.info("OrderCancelledEvent in Saga for Order Id : {}",
                event.getOrderId());
    }

    @SagaEventHandler(associationProperty = "orderId")
    public void handle(PaymentCancelledEvent event) {
    	LOGGER.info("PaymentCancelledEvent in Saga for Order Id : {}",
                event.getOrderId());
        cancelOrderCommand(event.getOrderId());
    }
}