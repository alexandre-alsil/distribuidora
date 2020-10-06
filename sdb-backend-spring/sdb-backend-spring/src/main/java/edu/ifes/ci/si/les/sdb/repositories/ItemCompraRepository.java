package edu.ifes.ci.si.les.sdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifes.ci.si.les.sdb.model.ItemCompra;
import edu.ifes.ci.si.les.sdb.model.ItemDeCompraPK;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, ItemDeCompraPK>{

}
