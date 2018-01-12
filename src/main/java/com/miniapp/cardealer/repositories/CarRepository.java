package com.miniapp.cardealer.repositories;

import com.miniapp.cardealer.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    List<Car> findAllByOrderByMakeAscTravelledDistanceDesc();
    List<Car> getByMakeOrderByModelAscTravelledDistanceDesc(String make);
}
