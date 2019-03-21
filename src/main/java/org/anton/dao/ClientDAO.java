package org.anton.dao;

import org.anton.model.Client;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.03.2019.
 */
@Component
public class ClientDAO {

    private static Connection conn;

    static {
        String url = "jdbc:postgresql://localhost:5432/CRUD_DB";
        String user = "postgres";
        String password = "1234";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean add(Client client) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO clients(name, surname, phone, city, status) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setString(3, client.getPhone());
            ps.setString(4, client.getCity());
            ps.setInt(5, client.getStatus());
            ps.execute();
            return true;
        } catch (SQLException ignored) {}
        return false;
    }

    public boolean update(Client client) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE clients SET name = ?, surname = ?, phone = ?, city = ?, status = ? WHERE id = ?");
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setString(3, client.getPhone());
            ps.setString(4, client.getCity());
            ps.setInt(5, client.getStatus());
            ps.setInt(6, client.getID());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM clients WHERE id = ?");
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException ignored) {}
        return false;
    }

    public Client getOne(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients WHERE id = ?");
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setID(ID);
                client.setName(rs.getString(2));
                client.setSurname(rs.getString(3));
                client.setPhone(rs.getString(4));
                client.setCity(rs.getString(5));
                client.setStatus(rs.getInt(6));
                return client;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM clients");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Client client = new Client();
                client.setID(rs.getInt(1));
                client.setName(rs.getString(2));
                client.setSurname(rs.getString(3));
                client.setPhone(rs.getString(4));
                client.setCity(rs.getString(5));
                client.setStatus(rs.getInt(6));
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
