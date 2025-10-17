package polytechdi4.parking_velo.service;

import polytechdi4.parking_velo.dto.VeloDTO;

import java.util.List;

public interface VeloService {
    List<VeloDTO> findAll();
    VeloDTO findById(Integer id);
    VeloDTO create(VeloDTO dto);
    VeloDTO update(Integer id, VeloDTO dto);
    void delete(Integer id);
}
