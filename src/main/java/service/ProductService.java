package service;

import entity.Product;
import lombok.RequiredArgsConstructor;
import models.ProductDto;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(ProductDto product) {
        Product newProduct = new Product();
        newProduct.setProductName(product.productName());
        newProduct.setProductPrice(product.productPrice());
        return productRepository.save(newProduct);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }


}
