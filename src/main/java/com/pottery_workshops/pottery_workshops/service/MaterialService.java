package com.pottery_workshops.pottery_workshops.service;

import com.pottery_workshops.pottery_workshops.model.Course;
import com.pottery_workshops.pottery_workshops.model.Material;
import com.pottery_workshops.pottery_workshops.repository.CourseRepository;
import com.pottery_workshops.pottery_workshops.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> findAll() {
        return materialRepository.findAll();
    }

    public Material save(Material material) {
        return materialRepository.save(material);
    }
}
