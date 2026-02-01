package com.demo.service;

import com.demo.entity.SchoolEntity;
import com.demo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository repository;

    public SchoolEntity save(SchoolEntity entity) {
        return repository.save(entity);
    }

    public SchoolEntity findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long rollNumber) {
        repository.deleteById(rollNumber);
    }

    public List<SchoolEntity> findAll() {
        return repository.findAll();
    }

    public long countStudents() {
        return repository.count();
    }
}
