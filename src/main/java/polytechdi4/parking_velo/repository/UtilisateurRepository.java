package polytechdi4.parking_velo.repository;

import polytechdi4.parking_velo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    boolean existsByMail(String email);
    boolean existsByMailAndIdNot(String mail, Long id);
}
