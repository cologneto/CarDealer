package com.miniapp.cardealer.services;

import com.miniapp.cardealer.entities.Customer;
import com.miniapp.cardealer.models.viewModels.CustomerView;
import com.miniapp.cardealer.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<CustomerView> getAllOrderByBirthDate(String type) {
        List<Customer> customers = new ArrayList<>();
        if ("Descending".equals(type)) {
            customers = this.customerRepository.getAllByOrderByBirthDateDescIsYoungDriverAsc();
        } else {
            customers = this.customerRepository.getAllByOrderByBirthDateAscIsYoungDriverAsc();
        }

        ModelMapper modelMapper = new ModelMapper();
        List<CustomerView> customerViews = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerView customerView = modelMapper.map(customer, CustomerView.class);
            customerViews.add(customerView);
        }


        return customerViews;
    }
}
