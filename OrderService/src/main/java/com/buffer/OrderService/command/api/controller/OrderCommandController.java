package com.buffer.OrderService.command.api.controller;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buffer.OrderService.command.api.command.CreateOrderCommand;
import com.buffer.OrderService.command.api.model.OrderRestModel;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderCommandController {

    private CommandGateway commandGateway;

    public OrderCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderRestModel orderRestModel) {

        String orderId = UUID.randomUUID().toString();

        CreateOrderCommand createOrderCommand
                = new CreateOrderCommand();
        createOrderCommand.setOrderId(orderId);
        createOrderCommand.setAddressId(orderRestModel.getAddressId());
        createOrderCommand.setProductId(orderRestModel.getProductId());
        createOrderCommand.setQuantity(orderRestModel.getQuantity());
        createOrderCommand.setOrderStatus("CREATED");

        commandGateway.sendAndWait(createOrderCommand);

        return "Order Created";
    }
}