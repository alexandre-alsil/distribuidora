package edu.ifes.ci.si.les.sdb.model;

import java.io.Serializable;
import java.util.Objects;

public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String nome;

    private UF uf;

    public Cidade() {
        // TODO Auto-generated constructor stub
    }

    public Cidade(Integer id, String nome, UF uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public UF getUf() {
        return uf;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

}
