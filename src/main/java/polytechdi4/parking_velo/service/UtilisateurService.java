// UtilisateurService.java
package polytechdi4.parking_velo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polytechdi4.parking_velo.dto.UtilisateurDTO;
import polytechdi4.parking_velo.exception.ConflictException;
import polytechdi4.parking_velo.exception.NotFoundException;
import polytechdi4.parking_velo.mapper.UtilisateurMapper;
import polytechdi4.parking_velo.model.Utilisateur;
import polytechdi4.parking_velo.repository.UtilisateurRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UtilisateurService {

    private final UtilisateurRepository repo;
    private final UtilisateurMapper mapper;

    public UtilisateurDTO create(UtilisateurDTO dto) {
        if (repo.existsByMail(dto.getMail())) {
            throw new ConflictException("Email déjà utilisé : " + dto.getMail());
        }
        Utilisateur saved = repo.save(mapper.toEntity(dto));
        return mapper.toDto(saved);
    }

    @Transactional(readOnly = true)
    public UtilisateurDTO get(Long id) {
        Utilisateur u = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Utilisateur " + id + " introuvable"));
        return mapper.toDto(u);
    }

    @Transactional(readOnly = true)
    public List<UtilisateurDTO> list() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    public UtilisateurDTO update(Long id, UtilisateurDTO dto) {
        Utilisateur existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Utilisateur " + id + " introuvable"));
        if (dto.getMail()!=null && repo.existsByMailAndIdNot(dto.getMail(), Math.toIntExact(id))) {
            throw new ConflictException("Email déjà utilisé : " + dto.getMail());
        }
        existing.setNom(dto.getNom()!=null ? dto.getNom() : existing.getNom());
        existing.setMail(dto.getMail()!=null ? dto.getMail() : existing.getMail());
        return mapper.toDto(repo.save(existing));
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Utilisateur " + id + " introuvable");
        }
        repo.deleteById(id);
    }
}
