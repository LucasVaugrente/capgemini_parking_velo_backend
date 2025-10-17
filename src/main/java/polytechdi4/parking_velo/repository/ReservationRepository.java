package polytechdi4.parking_velo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polytechdi4.parking_velo.model.Coordonnees;
import polytechdi4.parking_velo.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}