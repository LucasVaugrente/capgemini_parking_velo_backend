package polytechdi4.parking_velo.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polytechdi4.parking_velo.model.Utilisateur;
import polytechdi4.parking_velo.repository.UtilisateurRepository;

@Service
@Transactional
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public boolean removeUtilisateur(Long id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
            return true;
        }
        return false;
    }
}