package polytechdi4.parking_velo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import polytechdi4.parking_velo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("""
    SELECT CASE WHEN COUNT(r) > 0 THEN TRUE ELSE FALSE END
    FROM Reservation r
    WHERE r.velo.id = :veloId
    """)
    boolean existsOverlap(
            @Param("veloId") Long veloId
    );

}