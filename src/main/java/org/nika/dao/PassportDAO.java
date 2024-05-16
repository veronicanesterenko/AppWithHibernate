package org.nika.dao;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nika.models.Passenger;
import org.nika.models.Passport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PassportDAO {

    private final SessionFactory sessionFactory;

    public PassportDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Passport> getAllPassports() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Passport", Passport.class).getResultList();
    }

    public Passport getPassportByPassenger(int passengerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Passenger.class, passengerId).getPassport();
    }

    public void savePassport(Passport passport, int passengerId) {
        Session session = sessionFactory.getCurrentSession();
        Passenger passenger = session.get(Passenger.class, passengerId);
        passport.setPassenger(passenger);

        session.save(passport);
    }

    public void updatePassport(int id ,Passport updatedPassport) {
        Session session = sessionFactory.getCurrentSession();
        Passport passportToBeUpdated = session.get(Passport.class, id);
        passportToBeUpdated.setPassenger(updatedPassport.getPassenger());
        passportToBeUpdated.setNumber(updatedPassport.getNumber());
        passportToBeUpdated.setCitizenship(updatedPassport.getCitizenship());
    }

    public void deletePassport(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Passport.class, id));
    }
}
