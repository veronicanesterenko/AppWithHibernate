package org.nika.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.nika.dao.PassengerDAO;
import org.nika.models.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerDAO passengerDAO;

    @Transactional
    public List<Passenger> getAllPassengers() {
        return passengerDAO.getAllPassengers();
    }

    @Transactional
    public Passenger getPassengerById(int id) {
        return passengerDAO.getPassengerById(id);
    }

    @Transactional
    public void savePassenger(Passenger passenger) {
      passengerDAO.savePassenger(passenger);
    }

    @Transactional
    public void updatePassenger(int id ,Passenger updatedPassenger) {
       passengerDAO.updatePassenger(id, updatedPassenger);
    }

    @Transactional
    public void deletePassenger(int id) {
       passengerDAO.deletePassenger(id);
    }



}
