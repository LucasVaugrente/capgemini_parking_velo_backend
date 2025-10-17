package polytechdi4.parking_velo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import polytechdi4.parking_velo.dto.ReservationDTO;
import polytechdi4.parking_velo.mapper.ReservationMapper;
import polytechdi4.parking_velo.model.Reservation;
import polytechdi4.parking_velo.model.ReservationId;
import polytechdi4.parking_velo.repository.ReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;
    private final ReservationMapper mapper;

    @Override
    public List<ReservationDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public ReservationDTO findById(Integer utilisateurId, Integer veloId) {
        ReservationId id = new ReservationId(utilisateurId, veloId);

        Reservation entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));

        return mapper.toDTO(entity);
    }

    @Override
    public ReservationDTO create(ReservationDTO dto) {
        Reservation entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public ReservationDTO update(Integer utilisateurId, Integer veloId, ReservationDTO dto) {
        ReservationId id = new ReservationId(utilisateurId, veloId);

        Reservation entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));

        mapper.partialUpdate(entity, dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Integer utilisateurId, Integer veloId) {
        repository.deleteById(new ReservationId(utilisateurId, veloId));
    }
}
