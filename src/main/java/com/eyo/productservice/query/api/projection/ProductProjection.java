package com.eyo.productservice.query.api.projection;

import com.eyo.productservice.command.api.data.Product;
import com.eyo.productservice.command.api.model.ProductRestModel;
import com.eyo.productservice.command.api.repository.ProductRepository;
import com.eyo.productservice.query.api.queries.GetProductQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    private ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductQuery getProductQuery) {
        List<Product> products = productRepository.findAll();

        return products.stream().map(product -> ProductRestModel.builder()
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build()).collect(Collectors.toList());
    }
}
