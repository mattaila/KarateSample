package com.sample.karate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.karate.dto.SampleDTO;
import com.sample.karate.repository.SampleRepository;

/**
 * SampleServiceクラス
 */
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    SampleRepository repository;
    
    @Override
    public SampleDTO get(long id) {
        return repository.searchById(id);
    }

    @Override
    public List<SampleDTO> list() {
        return repository.search();
    }
    
    @Override
    public void create(SampleDTO sampleDto) {
        repository.insert(sampleDto);
    }

    @Override
    public void update(long id, SampleDTO sampleDto) {
        repository.update(id, sampleDto);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
