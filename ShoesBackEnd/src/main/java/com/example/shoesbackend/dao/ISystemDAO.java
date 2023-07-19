package com.example.shoesbackend.dao;

import com.example.shoesbackend.entities.Client;
import com.example.shoesbackend.entities.Shoe;

import java.util.Collection;
import java.util.List;

public interface ISystemDAO {
    Client addClient(String fullName);

    Shoe addShoe(int idClient, Shoe shoe);
    Shoe addShoeInventory(String name);

    Shoe deleteShoe(int id);

    Shoe seeShoe(int id);

    List<Shoe> SeeShoeByPrice(double price);

    List<Shoe> SeeShoeByBrand(String brand);

    Collection<Shoe> seeAllShoesInCart(int IdClient);

    List<Shoe> seeAllShoes();
}
