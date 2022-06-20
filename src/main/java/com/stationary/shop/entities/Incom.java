package com.stationary.shop.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "incoms")
public class Incom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne
    private Product product;
    private Integer quantity;
    private Date incomDate;
    @OneToOne
    private Provider provider;

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Date getIncomDate() {
        return incomDate;
    }

    public void setIncomDate(Date incomDate) {
        this.incomDate = incomDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Incom() {
    }
}
