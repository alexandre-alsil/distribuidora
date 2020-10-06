package edu.ifes.ci.si.les.sdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifes.ci.si.les.sdb.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{

}
