package com.miniapp.cardealer.repositories;

import com.miniapp.cardealer.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> getAllByIsImporter(Boolean importer);
    List<Supplier> getFirstByName(String name);
}
