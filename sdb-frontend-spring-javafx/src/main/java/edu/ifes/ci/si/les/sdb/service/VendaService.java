/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.service;

import edu.ifes.ci.si.les.sdb.model.Venda;
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
public class VendaService {
    private final String URL = "http://localhost:8080/vendas/";
    private final Client client = ClientBuilder.newClient();
    
    public Venda find(Integer id) {
        try {
            WebTarget target = client.target(URL + id);
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            Venda venda = mapper.readValue(json, Venda.class);
            return venda;
        } catch (IOException ex) {
            Logger.getLogger(VendaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Venda> findAll() {
        try {
            WebTarget target = client.target(URL);
            String json = target.request().get(String.class);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Venda>> mapType = new TypeReference<List<Venda>>() {
            };
            List<Venda> lista = mapper.readValue(json, mapType);
            return lista;
        } catch (IOException ex) {
            Logger.getLogger(VendaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insert(Venda venda) {
        try {
            WebTarget target = client.target(URL);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(venda);
            target.request().post(Entity.entity(json, "application/json;charset=UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(VendaService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(Venda venda) {
        try {
            WebTarget target = client.target(URL);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(venda);
            target.request().put(Entity.entity(json, "application/json;charset=UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(VendaService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(Integer id) {
        WebTarget target = client.target(URL + id);
        target.request().delete();
    }
    
}
