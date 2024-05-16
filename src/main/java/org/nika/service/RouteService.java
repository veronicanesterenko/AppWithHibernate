package org.nika.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.nika.dao.RouteDAO;
import org.nika.models.Route;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteService {
    private final RouteDAO routeDAO;

    @Transactional
    public List<Route> getAllRoutes() {
      return routeDAO.getAllRoutes();
    }
    @Transactional
    public Route getRouteById(int id) {
        return routeDAO.getRouteById(id);
    }

    @Transactional
    public void saveRoute(Route route) {
        routeDAO.saveRoute(route);
    }

    @Transactional
    public void updateRoute (int id, Route updatedRoute) {
        routeDAO.updateRoute(id, updatedRoute);
    }

    @Transactional
    public void deleteRoute(int id) {
       routeDAO.deleteRoute(id);
    }
}
