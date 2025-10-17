package polytechdi4.parking_velo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polytechdi4.parking_velo.model.Utilisateur;
import polytechdi4.parking_velo.repository.UtilisateurRepository;

import java.util.List;

@Service
@Transactional
public class UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository UtilisateurRepository) {
        this.utilisateurRepository = UtilisateurRepository;
    }

    public Utilisateur addUser(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    public Utilisateur getUser(Long userId) {
        return utilisateurRepository.findById(userId).orElse(null);
    }

    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur updateUser(Utilisateur user) {
        return utilisateurRepository.save(user);
    }

    public void removeUser(Long userId) {
        utilisateurRepository.deleteById(userId);
    }
}