package com.example.shoesbackend.services;

import com.example.shoesbackend.dao.ISystemDAO;
import com.example.shoesbackend.dao.SystemDAOImpl;
import com.example.shoesbackend.entities.Client;
import com.example.shoesbackend.entities.Shoe;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/system")
public class SystemResource {

    ISystemDAO dao = null;
    public SystemResource(){
        dao = new SystemDAOImpl();
    }

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @Path("/shoe")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Shoe> findAllShoes() {
        if (dao != null) {
            return dao.seeAllShoes();
        }
        return null;
    }

    @Path("/client/{fullName}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Client AddClient(@PathParam("fullName") String fullName) {
        if(dao !=null)
            return dao.addClient(fullName);
        return null;
    }

    @Path("/shoe/{name}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Shoe AddShoeInventory(@PathParam("name") String name) {
        if(dao !=null)
            return dao.addShoeInventory(name);
        return null;
    }

}