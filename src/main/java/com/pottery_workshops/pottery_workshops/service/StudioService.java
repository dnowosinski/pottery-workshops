package com.pottery_workshops.pottery_workshops.service;

import com.pottery_workshops.pottery_workshops.model.Studio;
import com.pottery_workshops.pottery_workshops.repository.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {
    @Autowired
    private StudioRepository studioRepository;

    public List<Studio> findAll() {
        return studioRepository.findAll();
    }

    public Studio save(Studio studio) {
        return studioRepository.save(studio);
    }
}
