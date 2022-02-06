package com.eyo.productservice.command.api.events;

import com.eyo.productservice.command.api.data.Product;
import com.eyo.productservice.command.api.repository.ProductRepository;
import com.sun.jdi.event.ExceptionEvent;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("prroduct")
public class ProductEventHandler {

    private final ProductRepository productRepository;

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductCreatedEvent event) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(event, product);
        productRepository.save(product);
        throw new Exception("Exception Occurred");
    }

    @ExceptionHandler
    public void handle(Exception e) throws Exception {
        throw e;
    }
}
