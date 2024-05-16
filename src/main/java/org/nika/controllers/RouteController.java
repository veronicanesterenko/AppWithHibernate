package org.nika.controllers;


import lombok.RequiredArgsConstructor;
import org.nika.models.Passenger;
import org.nika.models.Route;
import org.nika.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/routes")
@RequiredArgsConstructor
public class RouteController {

    private final RouteService routeService;

    @GetMapping()
    public String findAllRoutes(Model model) {
        model.addAttribute("routes", routeService.getAllRoutes());
        return "routes/routes_list";
    }

    @GetMapping("/{id}")
    public String findRouteById(@PathVariable("id") int id, Model model) {
        model.addAttribute("route", routeService.getRouteById(id));
        return "routes/route";
    }

    @GetMapping("new")
    public String newRoute(@ModelAttribute("route") Route route) {
        return "routes/new";
    }

    @PostMapping()
    public String saveRoute(@ModelAttribute("passenger") Route route) {
        routeService.saveRoute(route);
        return "redirect:/routes";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("route", routeService.getRouteById(id));
        return "routes/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("route") Route route,
                         @PathVariable("id") int id) {
        routeService.updateRoute(id, route);
        return "redirect:/routes";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        routeService.deleteRoute(id);
        return "redirect:/routes";
    }
}
