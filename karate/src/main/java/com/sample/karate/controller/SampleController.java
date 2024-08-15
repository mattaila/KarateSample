package com.sample.karate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.karate.dto.SampleDTO;
import com.sample.karate.service.SampleServiceImpl;

@RestController
public class SampleController {

    @Autowired
    private SampleServiceImpl service;

    @GetMapping("/get/{id}")
    public SampleDTO get(@PathVariable long id) {
        return service.get(id);
    }

    @GetMapping("/list")
    public List<SampleDTO> list() {
        return service.list();
    }

    @PostMapping("/create")
    public void create(@RequestBody SampleDTO sampleDto) {
        service.create(sampleDto);
    }

    @RequestMapping("/update/{id}")
    public void update(@PathVariable long id, @RequestBody SampleDTO sampleDto) {
        service.update(id, sampleDto);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}
