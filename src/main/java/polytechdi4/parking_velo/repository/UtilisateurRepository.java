package polytechdi4.parking_velo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polytechdi4.parking_velo.model.Coordonnees;
import polytechdi4.parking_velo.model.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
}