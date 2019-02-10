package com.demo.basicApp.model;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "USER")
public class User extends BaseEntity{

    @Id
//    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "USER_NAME")
    private String name;
    @Column(name = "USER_EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_PRODUCT", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID")})
    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

//    public void setId(String id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

//    @PrePersist
//    private void generateRandomId() {
//        this.id = UUID.randomUUID().toString();
//    }
}
