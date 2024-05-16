package org.nika.controllers;

import lombok.RequiredArgsConstructor;
import org.nika.dao.PassengerDAO;
import org.nika.dao.PassportDAO;
import org.nika.models.Passenger;
import org.nika.models.Passport;
import org.nika.service.PassengerService;
import org.nika.service.PassportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/passengers")
@RequiredArgsConstructor
public class PassengersController {

    private final PassengerService passengerService;
    private final PassportService passportService;



    @GetMapping()
    public String findAllPassengers(Model model) {
        model.addAttribute("passengers", passengerService.getAllPassengers());
        return "passengers/passengers_list";
    }

    @GetMapping("/{id}")
    public String findPassengerById(@PathVariable("id") int id, Model model) {
        model.addAttribute("passenger", passengerService.getPassengerById(id));
        return "passengers/passenger";
    }

    @GetMapping("new")
    public String newPassenger(@ModelAttribute("passenger") Passenger passenger) {
        return "passengers/new";
    }

    @PostMapping()
    public String savePassenger(@ModelAttribute("passenger") Passenger passenger) {
        passengerService.savePassenger(passenger);
        return "redirect:/passengers";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("passenger", passengerService.getPassengerById(id));
        return "passengers/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("passenger") Passenger passenger,
                         @PathVariable("id") int id) {

        passengerService.updatePassenger(id, passenger);
        return "redirect:/passenger";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        passengerService.deletePassenger(id);
        return "redirect:/passengers";
    }

    @GetMapping("/{id}/passport")
    public String findPassportById( @PathVariable("id") int id, Model model) {
        model.addAttribute("passport", passportService.getPassportByPassenger(id));
        return "passengers/passport";
    }

    @GetMapping("{id}/passport/new")
    public String newPassport(@ModelAttribute("passport") Passport passport,
                              @PathVariable("id") int id, Model model) {
        model.addAttribute("passenger", passengerService.getPassengerById(id));
        return "passengers/passport_new";
    }

    @PostMapping("{id}/passport")
    public String savePassport(@ModelAttribute("passport") Passport passport,
                               @PathVariable("id") int id) {
        System.out.println(passport);
        passportService.savePassport(passport, id);
        return "redirect:/passengers";
    }

    @GetMapping("/{id}/passport/edit")
    public String editPassport(@PathVariable("id") int id, Model model) {
        model.addAttribute("passenger", passengerService.getPassengerById(id));
        model.addAttribute("passport", passengerService.getPassengerById(id).getPassport());

        return "passengers/passport_edit";
    }



   /* @PatchMapping("/{id}/passport")
    public String updatePassport(@PathVariable("id") int id, Model model) {

    }*/
   }
