package com.pottery_workshops.pottery_workshops.service;

import com.pottery_workshops.pottery_workshops.model.ContractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractTypeService {
    @Autowired
    private ContractTypeService contractTypeService;

    public List<ContractType> findAll() {
        return contractTypeService.findAll();
    }

    public ContractType save(ContractType contractType) {
        return contractTypeService.save(contractType);
    }
}
