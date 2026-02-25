package az.edu.ada.wm2.lab4.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Product {
    private UUID id;
    private String productName;
    private BigDecimal price;
    private LocalDate expirationDate;

    public Product() {
    }

    public Product(String productName, BigDecimal price, LocalDate expirationDate) {
        this.productName = productName;
        this.price = price;
        this.expirationDate = expirationDate;
    }
    
    public Product(UUID id, String productName, BigDecimal price, LocalDate expirationDate) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.expirationDate = expirationDate;
    }


    public UUID getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    



    
}
