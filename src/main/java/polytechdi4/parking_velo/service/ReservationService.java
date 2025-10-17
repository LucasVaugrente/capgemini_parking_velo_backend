package polytechdi4.parking_velo.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytechdi4.parking_velo.model.Reservation;
import polytechdi4.parking_velo.repository.ReservationRepository;

@Service
@Transactional
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public boolean removeReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}