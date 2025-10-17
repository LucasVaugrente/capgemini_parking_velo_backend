package polytechdi4.parking_velo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polytechdi4.parking_velo.model.Reservation;
import polytechdi4.parking_velo.model.Utilisateur;
import polytechdi4.parking_velo.repository.ReservationRepository;

import java.util.List;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getReservation(Long reservationId) {
        return reservationRepository.findById(reservationId).orElse(null);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void removeReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }
}