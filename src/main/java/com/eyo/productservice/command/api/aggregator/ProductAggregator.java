package com.eyo.productservice.command.api.aggregator;

import com.eyo.productservice.command.api.commands.CreateProductCommand;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregator {

    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public ProductAggregator(CreateProductCommand createProductCommand) {

    }

    public ProductAggregator() {

    }
}
