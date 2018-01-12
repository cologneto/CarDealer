package com.miniapp.cardealer.repositories;

import com.miniapp.cardealer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> getAllByOrderByBirthDateAscIsYoungDriverAsc();
    List<Customer> getAllByOrderByBirthDateDescIsYoungDriverAsc();
}
