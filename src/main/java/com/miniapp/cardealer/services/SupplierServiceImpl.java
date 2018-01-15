package com.miniapp.cardealer.services;

import com.miniapp.cardealer.entities.Supplier;
import com.miniapp.cardealer.models.viewModels.SupplierView;
import com.miniapp.cardealer.repositories.SupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public List<SupplierView> getAllByImporter(Boolean importer) {
        List<SupplierView> supplierViews = new ArrayList<>();
        List<Supplier> suppliers = supplierRepository.getAllByIsImporter(importer);
        ModelMapper modelMapper = new ModelMapper();

        for (Supplier supplier : suppliers) {
            SupplierView supplierView = modelMapper.map(supplier, SupplierView.class);
            supplierViews.add(supplierView);
        }



        return supplierViews;
    }
}
