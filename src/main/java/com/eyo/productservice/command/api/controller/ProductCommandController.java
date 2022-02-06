package com.eyo.productservice.command.api.controller;

import com.eyo.productservice.command.api.commands.CreateProductCommand;
import com.eyo.productservice.command.api.model.ProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    private final CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    String addProduct(@RequestBody ProductRestModel restModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .name(restModel.getName())
                .price(restModel.getPrice())
                .quantity(restModel.getQuantity())
                .build();
        return commandGateway.sendAndWait(createProductCommand);
    }
}
