package com.pottery_workshops.pottery_workshops.service;

import com.pottery_workshops.pottery_workshops.model.Potter;
import com.pottery_workshops.pottery_workshops.repository.PotterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotterService {
    @Autowired
    private PotterRepository potterRepository;

    public List<Potter> findAll() {
        return potterRepository.findAll();
    }

    public Potter save(Potter potter) {
        return potterRepository.save(potter);
    }
}
