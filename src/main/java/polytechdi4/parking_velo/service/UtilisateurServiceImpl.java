package polytechdi4.parking_velo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import polytechdi4.parking_velo.dto.UtilisateurDTO;
import polytechdi4.parking_velo.mapper.UtilisateurMapper;
import polytechdi4.parking_velo.model.Utilisateur;
import polytechdi4.parking_velo.repository.UtilisateurRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository repository;
    private final UtilisateurMapper mapper;

    @Override
    public List<UtilisateurDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public UtilisateurDTO findById(Integer id) {
        Utilisateur u = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur not found"));
        return mapper.toDTO(u);
    }

    @Override
    public UtilisateurDTO create(UtilisateurDTO dto) {
        Utilisateur entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public UtilisateurDTO update(Integer id, UtilisateurDTO dto) {
        Utilisateur entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur not found"));

        mapper.partialUpdate(entity, dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
