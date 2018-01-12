package com.miniapp.cardealer.services;

import com.miniapp.cardealer.models.viewModels.CustomerView;

import java.util.List;

public interface CustomerService {
    List<CustomerView> getAllOrderByBirthDate(String type);
}
