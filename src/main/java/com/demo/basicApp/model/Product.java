package com.demo.basicApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PRODUCT")
public class Product extends BaseEntity{
    @Id
//    @Column(name = "PRODUCT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;
    @NotNull
    @Column(name = "PRODUCT_NAME")
    private String productName;

    @NotNull
    @Column(name = "PRODUCT_PRICE")
    private double productPrice;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "productList")
    private List<User> userList;

    public List<User> getProductList() {
        return userList;
    }

    public void setProductList(List<User> productList) {
        this.userList = productList;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

//    @PrePersist
//    private void generateProdId() {
//        this.productId = UUID.randomUUID().toString();
//    }

}
