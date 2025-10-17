package polytechdi4.parking_velo.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import polytechdi4.parking_velo.dto.VeloDTO;
import polytechdi4.parking_velo.mapper.VeloMapper;
import polytechdi4.parking_velo.model.Velo;
import polytechdi4.parking_velo.repository.VeloRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeloServiceImpl implements VeloService {

    private final VeloRepository repository;
    private final VeloMapper mapper;

    @Override
    public List<VeloDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public VeloDTO findById(Integer id) {
        Velo v = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Velo not found"));
        return mapper.toDTO(v);
    }

    @Override
    public VeloDTO create(VeloDTO dto) {
        Velo entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public VeloDTO update(Integer id, VeloDTO dto) {
        Velo entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Velo not found"));

        mapper.partialUpdate(entity, dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
