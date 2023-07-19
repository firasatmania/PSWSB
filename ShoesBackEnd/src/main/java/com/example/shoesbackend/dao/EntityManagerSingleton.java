package com.example.shoesbackend.dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerSingleton {
    private static EntityManagerSingleton singleInstance= null;
    public EntityManager manager= null;

    private EntityManagerSingleton() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("shoes");
        this.manager = factory.createEntityManager();
    }

    public static EntityManagerSingleton getInstance(){
        if (singleInstance == null) {
            singleInstance = new EntityManagerSingleton();
        }
        return singleInstance;
    }
}

