package com.stationary.shop.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "providers")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id")
    private List<Incom> incoms;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Incom> getIncoms() {
        return incoms;
    }

    public void setIncoms(List<Incom> incoms) {
        this.incoms = incoms;
    }

    public Long getId() {
        return id;
    }

    public Provider() {
    }
}
