package com.example.shoesbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "cart")
    private Collection<Shoe> shoes;

    @OneToOne()
    @JoinColumn(name= "id_client", referencedColumnName = "id")
    @JsonIgnore
    private Client client;

    public Cart() {
    }

    public Cart(int id, Collection<Shoe> shoes, Client client) {
        this.id = id;
        this.shoes = shoes;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(Collection<Shoe> shoes) {
        this.shoes = shoes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
