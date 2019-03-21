package org.anton.model;

/**
 * Created by Admin on 17.03.2019.
 */
public class Client {

    private int ID;
    private String name;
    private String surname;
    private String phone;
    private String city;
    private int status;

    public Client() {}

    public Client(int ID, String name, String surname, String phone, String city, int status) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
        this.status = status;
    }

    public Client(String name, String surname, String phone, String city, int status) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.city = city;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getStatusText() {
        switch (status) {
            case 1: return "new client";
            case 2: return "interested";
            case 3: return "order is processed";
            case 4: return "order completed";
            case 5: return "order cancelled";
        }
        return "error_status";
    }
}
