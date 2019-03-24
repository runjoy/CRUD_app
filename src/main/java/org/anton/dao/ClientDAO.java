package org.anton.dao;

import org.anton.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.03.2019.
 */
@Component
public class ClientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Client client) {
        jdbcTemplate.update("INSERT INTO clients(name, surname, phone, city, status) VALUES(?, ?, ?, ?, ?)",
                client.getName(), client.getSurname(), client.getPhone(), client.getCity(), client.getStatus());
    }

    public void update(Client client) {
        jdbcTemplate.update("UPDATE clients SET name = ?, surname = ?, phone = ?, city = ?, status = ? WHERE id = ?)",
                client.getName(), client.getSurname(), client.getPhone(), client.getCity(), client.getStatus(),
                client.getID());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM clients WHERE id = ?",
                id);
    }

    public Client getOne(int ID) {
        return jdbcTemplate.queryForObject("SELECT * FROM clients WHERE id = ?",
                new Object[] { ID },
                new BeanPropertyRowMapper<>(Client.class));
    }

    public List<Client> getAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                new BeanPropertyRowMapper<>(Client.class));
    }
}
