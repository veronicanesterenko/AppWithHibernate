package org.nika.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.nika.models.Ticket;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

@Component
public class TicketDAO {

    private final SessionFactory sessionFactory;

    public TicketDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Ticket getTicketByPassengerId(int passengerId) {
        Session session = sessionFactory.getCurrentSession();
                String sql = "select ticket.id, passenger.full_name, `date`.`date`, route.`time`, route.departure_point, route.arrival_point, route.price, seat.`number` from ticket\n" +
                "join passenger on passenger_id = passenger.id\n" +
                "join `date` on date_id = `date`.id\n" +
                "join seat on seat_id = seat.id\n" +
                "join route on route_id = route.id\n" +
                "where passenger_id = ?;";
        return (Ticket) session.createSelectionQuery(sql, Ticket.class);
    }

}
