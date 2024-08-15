package com.sample.karate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sample.karate.dto.SampleDTO;

@Repository
@Transactional
public class SampleRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SampleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(SampleDTO dto) {
        jdbcTemplate.update("INSERT INTO SAMPLE(id, name, description) VALUES (?, ?, ?)",
            dto.getId(),
            dto.getName(),
            dto.getDescription());
    }

    public void update(long id, SampleDTO dto) {
        jdbcTemplate.update("UPDATE SAMPLE SET description = ? WHERE id = ?", 
            dto.getDescription(),
            dto.getId());
    }

    public SampleDTO searchById(long id) {
        return jdbcTemplate.queryForObject("SELECT id, name, description FROM SAMPLE WHERE id = ?",
            new BeanPropertyRowMapper<SampleDTO>(SampleDTO.class), id);
    }

    public List<SampleDTO> search() {
        return jdbcTemplate.query("SELECT id, name, description FROM SAMPLE",
            new BeanPropertyRowMapper<SampleDTO>(SampleDTO.class));
    }

    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM SAMPLE WHERE id = ?", id);
    }
}
