package org.nika.controllers;

import org.nika.dao.PassengerDAO;
import org.nika.dao.PassportDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("passports")
public class PassportController {
    private final PassportDAO passportDAO;
    private final PassengerDAO passengerDAO;

    public PassportController(PassportDAO passportDAO, PassengerDAO passengerDAO) {
        this.passportDAO = passportDAO;
        this.passengerDAO = passengerDAO;
    }

    @GetMapping("/{id}")
    public String findPassportByPassengerId(@PathVariable("id") int id, Model model) {
       model.addAttribute("passenger", passengerDAO.getPassengerById(id));
        model.addAttribute("passport", passportDAO.getPassportByPassenger(id));
        return "passports/passport";
    }

}
