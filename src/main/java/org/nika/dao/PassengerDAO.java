package org.nika.dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nika.models.Passenger;
import org.nika.models.Passport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassengerDAO {
   private final SessionFactory sessionFactory;

    public PassengerDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Passenger> getAllPassengers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Passenger", Passenger.class).getResultList();
    }


    public Passenger getPassengerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Passenger.class, id);
    }


    public void savePassenger(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(passenger);
    }


    public void updatePassenger(int id ,Passenger updatedPassenger) {
        Session session = sessionFactory.getCurrentSession();
        Passenger passengerToBeUpdated = session.get(Passenger.class, id);
        passengerToBeUpdated.setFullName(updatedPassenger.getFullName());
    }



    public void deletePassenger(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Passenger.class, id));
    }

}