package com.miniapp.cardealer.services;

import com.miniapp.cardealer.models.viewModels.CarView;
import com.miniapp.cardealer.models.viewModels.CarWithPartsView;

import java.util.List;

public interface CarService  {
    List<CarView> getAll();
    List<CarView> getByMake(String make);
    CarWithPartsView getById(Long id);
}
