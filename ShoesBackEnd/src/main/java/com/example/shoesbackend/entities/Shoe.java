package com.example.shoesbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "shoe")
public class Shoe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private double price;

    @Column(name = "size")
    private double size;

    @Column(name = "genre")
    private String genre;


    @Column(name = "quantity")
    private int quantity;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name= "id_cart", referencedColumnName = "id")
    @JsonIgnore
    private Cart cart;

    public Shoe() {
    }

    public Shoe(int id, String name, String brand, String color, double price, int quantity, String url, Cart cart) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.url = url;
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
