package com.sample.karate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.karate.dto.SampleDTO;

@Service
public interface SampleService {

    public SampleDTO get(long id);
    public List<SampleDTO> list();
    public void create(SampleDTO sampleDto);
    public void update(long id,  SampleDTO sampleDto);
    public void delete(long id);

}
