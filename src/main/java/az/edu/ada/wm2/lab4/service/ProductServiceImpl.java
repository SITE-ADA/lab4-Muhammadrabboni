package az.edu.ada.wm2.lab4.service;
import az.edu.ada.wm2.lab4.model.Product;
import az.edu.ada.wm2.lab4.repository.ProductRepository;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
     
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

     
    @Override
    public Product createProduct(Product product) {
        if (product.getId() == null) {
            product.setId(UUID.randomUUID());
        }
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
public Product updateProduct(UUID id, Product product) {

    if (!productRepository.existsById(id)) {
        throw new RuntimeException("Product not found with id: " + id);
    }

    product.setId(id);

    return productRepository.save(product);
}

    @Override
    public void deleteProduct(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsExpiringBefore(LocalDate date) {
        return productRepository.findAll().stream()
                .filter(product -> product.getExpirationDate() != null && product.getExpirationDate().isBefore(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getProductsByPriceRange(BigDecimal min, BigDecimal max) {
        return productRepository.findAll().stream()
                .filter(product -> product.getPrice() != null &&
                        product.getPrice().compareTo(min) >= 0 &&
                        product.getPrice().compareTo(max) <= 0)
                .collect(Collectors.toList());
    }


}