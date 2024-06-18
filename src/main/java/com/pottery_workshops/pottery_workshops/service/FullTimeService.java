package com.pottery_workshops.pottery_workshops.service;

import com.pottery_workshops.pottery_workshops.model.FullTime;
import com.pottery_workshops.pottery_workshops.repository.FullTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FullTimeService {
    @Autowired
    private FullTimeRepository fullTimeRepository;

    public List<FullTime> findAll() {
        return fullTimeRepository.findAll();
    }

    public FullTime save(FullTime fullTime) {
        return fullTimeRepository.save(fullTime);
    }
}