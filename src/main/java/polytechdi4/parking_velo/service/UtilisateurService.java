package polytechdi4.parking_velo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polytechdi4.parking_velo.model.Utilisateur;
import polytechdi4.parking_velo.repository.UtilisateurRepository;

@Service
@Transactional
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository UtilisateurRepository) {
        this.utilisateurRepository = UtilisateurRepository;
    }

    public void addUser(Utilisateur user) {

    }

    public void removeUser(Long userId) {

    }
}