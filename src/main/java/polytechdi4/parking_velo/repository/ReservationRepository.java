package polytechdi4.parking_velo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import polytechdi4.parking_velo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("""
           select case when count(r)>0 then true else false end
           from Reservation r
           where r.velo.id = :veloId
             and r.debut < :fin
             and r.fin > :debut
           """)
    boolean existsOverlap(@Param("veloId") Long veloId,
                          @Param("debut") LocalDateTime debut,
                          @Param("fin") LocalDateTime fin);
}