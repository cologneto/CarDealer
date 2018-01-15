package com.miniapp.cardealer.services;

import com.miniapp.cardealer.entities.Supplier;
import com.miniapp.cardealer.models.viewModels.SupplierView;

import java.util.List;

public interface SupplierService {
    List<SupplierView> getAllByImporter(Boolean importer);
}
