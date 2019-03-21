package org.anton;

import org.anton.dao.ClientDAO;
import org.anton.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 17.03.2019.
 */
@Controller
public class MainController {

    @Autowired
    private ClientDAO clientDAO;

    @GetMapping("/")
    public String view(Model model) {
        model.addAttribute("clients", clientDAO.getAll());
        return "/index";
    }

    @GetMapping("/add")
    public String getAddClient(Model model) {
        return "add_client";
    }

    @PostMapping("/add")
    public String addClient(
                            @RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            @RequestParam("phone") String phone,
                            @RequestParam("city") String city,
                            @RequestParam("status") int status) {
        clientDAO.add(new Client(name, surname, phone, city, status));
        return "redirect:/";
    }

    @GetMapping("/update")
    public String getUpdateClient(
            @RequestParam("id") int ID, Model model) {
        Client client = clientDAO.getOne(ID);
        model.addAttribute("client", client);
        return "update_client";
    }

    @PostMapping("/update")
    public String updateClient(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("phone") String phone,
            @RequestParam("city") String city,
            @RequestParam("status") int status) {
        clientDAO.update(new Client(id, name, surname, phone, city, status));
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteClient(
            @RequestParam("id") int id) {
        clientDAO.delete(id);
        return "redirect:/";
    }
}
