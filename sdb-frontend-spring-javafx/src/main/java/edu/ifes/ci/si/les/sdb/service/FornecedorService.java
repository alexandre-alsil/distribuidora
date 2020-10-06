/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.service;

import edu.ifes.ci.si.les.sdb.model.Fornecedor;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Alexandre
 */
public class FornecedorService {

    private final String URL = "http://localhost:8080/fornecedores/";
    private final Client client = ClientBuilder.newClient();

    public Fornecedor find(Integer id) {
        try {
            WebTarget target = client.target(URL + id);
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            Fornecedor fornecedor = mapper.readValue(json, Fornecedor.class);
            return fornecedor;
        } catch (IOException ex) {
            Logger.getLogger(FornecedorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Fornecedor> findAll() {
        try {
            WebTarget target = client.target(URL);
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Fornecedor>> mapType = new TypeReference<List<Fornecedor>>() {
            };
            List<Fornecedor> lista = mapper.readValue(json, mapType);
            return lista;
        } catch (IOException ex) {
            Logger.getLogger(FornecedorService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Fornecedor fornecedor) {
        try {
            WebTarget target = client.target(URL);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(fornecedor);
            target.request().post(Entity.entity(json, "application/json;charset=UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(FornecedorService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(Fornecedor fornecedor) {
        try {
            WebTarget target = client.target(URL);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(fornecedor);
            target.request().put(Entity.entity(json, "application/json;charset=UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(FornecedorService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Integer id) {
        WebTarget target = client.target(URL + id);
        target.request().delete();
    }

}
