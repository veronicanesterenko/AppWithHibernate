package org.nika.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.nika.dao.PassportDAO;
import org.nika.models.Passenger;
import org.nika.models.Passport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassportService {

    private final PassportDAO passportDAO;

    @Transactional
    public List<Passport> getAllPassports() {
       return passportDAO.getAllPassports();
    }

    @Transactional
    public Passport getPassportByPassenger(int passengerId) {
      return passportDAO.getPassportByPassenger(passengerId);
    }

    @Transactional
    public void savePassport(Passport passport, int passengerId) {
       passportDAO.savePassport(passport, passengerId);
    }

    @Transactional
    public void updatePassport(int id ,Passport updatedPassport) {
        passportDAO.updatePassport(id, updatedPassport);
    }

    @Transactional
    public void deletePassport(int id) {
      passportDAO.deletePassport(id);
    }
}
