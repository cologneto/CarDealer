package com.miniapp.cardealer.services;

import com.miniapp.cardealer.entities.Car;
import com.miniapp.cardealer.models.viewModels.CarView;
import com.miniapp.cardealer.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarView> getAll() {
        List<Car> cars = this.carRepository.findAllByOrderByMakeAscTravelledDistanceDesc();
        List<CarView> carViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Car car : cars) {
            CarView carView = modelMapper.map(car,CarView.class);
            carViews.add(carView);
        }
        return carViews;
    }

    @Override
    public List<CarView> getByMake(String make) {
        List<Car> cars = this.carRepository.getByMakeOrderByModelAscTravelledDistanceDesc(make);
        List<CarView> carViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Car car : cars) {
            CarView carView = modelMapper.map(car,CarView.class);
            carViews.add(carView);
        }
        return carViews;
    }


}
