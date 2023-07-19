package com.example.shoesbackend.dao;

import com.example.shoesbackend.entities.Cart;
import com.example.shoesbackend.entities.Client;
import com.example.shoesbackend.entities.Shoe;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.Collection;
import java.util.List;

public class SystemDAOImpl implements ISystemDAO{
    private EntityManagerSingleton singleton;

    public SystemDAOImpl(){singleton = EntityManagerSingleton.getInstance();}

    @Override
    public Client addClient(String fullName) {
        if(singleton.manager !=null){
            EntityTransaction transaction = singleton.manager.getTransaction();
            transaction.begin();
            try {
                Client client = new Client();
                client.setFullName(fullName);
                Cart cart = new Cart();
                client.setCart(cart);
                cart.setClient(client);
                singleton.manager.persist(client);
                singleton.manager.persist(cart);
                transaction.commit();
                return client;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Shoe addShoe(int idClient, Shoe shoe) {
        return null;
    }

    @Override
    public Shoe addShoeInventory(String name) {
        if(singleton.manager !=null){
            EntityTransaction transaction = singleton.manager.getTransaction();
            transaction.begin();
            try {
                Shoe shoe = new Shoe();
                shoe.setName(name);
                singleton.manager.persist(shoe);
                transaction.commit();
                return shoe;
            } catch (Exception e) {
                transaction.rollback();
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Shoe deleteShoe(int id) {
        return null;
    }

    @Override
    public Shoe seeShoe(int id) {
        return null;
    }

    @Override
    public List<Shoe> SeeShoeByPrice(double price) {
        return null;
    }

    @Override
    public List<Shoe> SeeShoeByBrand(String brand) {
        return null;
    }

    /**
     *
     * @param IdClient
     * @return Tous les shoes dans le cart du client correspondant
     */
    @Override
    public Collection<Shoe> seeAllShoesInCart(int IdClient) {
        if(singleton != null) {
            try {
                Client client = singleton.manager.find(Client.class, IdClient);
                if(client != null){
                    return client.getCart().getShoes();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    /**
     *
     * @return all shoes in inventory
     */
    @Override
    public List<Shoe> seeAllShoes() {
        if (singleton != null) {
            Query query = singleton.manager.createQuery("SELECT c FROM Shoe c");
            return query.getResultList();
        }
        return null;
    }
}
