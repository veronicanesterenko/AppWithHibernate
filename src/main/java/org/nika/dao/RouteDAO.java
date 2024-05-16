package org.nika.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nika.models.Passenger;
import org.nika.models.Route;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RouteDAO {

    private final SessionFactory sessionFactory;

    public RouteDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Route> getAllRoutes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Route", Route.class).getResultList();
    }

    public Route getRouteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Route.class, id);
    }

    public void saveRoute(Route route) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(route);
    }

    public void updateRoute (int id, Route updatedRoute) {
        Session session = sessionFactory.getCurrentSession();
        Route routeToBeUpdated = session.get(Route.class, id);
        routeToBeUpdated.setTime(updatedRoute.getTime());
        routeToBeUpdated.setDeparturePoint(updatedRoute.getDeparturePoint());
        routeToBeUpdated.setArrivalPoint(updatedRoute.getArrivalPoint());
        routeToBeUpdated.setPrice(updatedRoute.getPrice());
        session.update(routeToBeUpdated);
    }

    public void deleteRoute(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Route.class, id));
    }
}
