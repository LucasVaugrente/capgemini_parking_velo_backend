// ReservationService.java
package polytechdi4.parking_velo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polytechdi4.parking_velo.dto.ReservationDTO;
import polytechdi4.parking_velo.exception.ConflictException;
import polytechdi4.parking_velo.exception.NotFoundException;
import polytechdi4.parking_velo.mapper.ReservationMapper;
import polytechdi4.parking_velo.model.Reservation;
import polytechdi4.parking_velo.repository.ReservationRepository;
import polytechdi4.parking_velo.repository.UtilisateurRepository;
import polytechdi4.parking_velo.repository.VeloRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {

    private final ReservationRepository repo;
    private final UtilisateurRepository userRepo;
    private final VeloRepository veloRepo;
    private final ReservationMapper mapper;

    public ReservationDTO create(ReservationDTO dto) {
        var user = userRepo.findById(dto.getUtilisateurId())
                .orElseThrow(() -> new NotFoundException("Utilisateur " + dto.getUtilisateurId() + " introuvable"));
        var velo = veloRepo.findById(dto.getVeloId())
                .orElseThrow(() -> new NotFoundException("Velo " + dto.getVeloId() + " introuvable"));

        boolean conflit = repo.existsOverlap(dto.getVeloId());
        if (conflit) {
            throw new ConflictException("Le créneau est déjà réservé pour ce vélo.");
        }

        Reservation entity = mapper.toEntity(dto);
        entity.setUtilisateur(user);
        entity.setVelo(velo);
        return mapper.toDto(repo.save(entity));
    }

    @Transactional(readOnly = true)
    public ReservationDTO get(Long id) {
        return repo.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException("Reservation " + id + " introuvable"));
    }

    @Transactional(readOnly = true)
    public List<ReservationDTO> list() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) throw new NotFoundException("Reservation " + id + " introuvable");
        repo.deleteById(id);
    }
}
