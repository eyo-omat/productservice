package com.eyo.productservice.query.api.controller;

import com.eyo.productservice.command.api.model.ProductRestModel;
import com.eyo.productservice.query.api.queries.GetProductQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    private QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getAllProducts() {
        GetProductQuery productQuery = new GetProductQuery();

        return queryGateway.query(productQuery,
                ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
    }
}
