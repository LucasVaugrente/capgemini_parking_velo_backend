package polytechdi4.parking_velo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polytechdi4.parking_velo.repository.ReservationRepository;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void addReservation() {

    }

    public void removeUser() {

    }

    public void updateReservation() {

    }

    public void getReservationsByUser() {

    }

    public void getReservationsByVelo() {

    }
}