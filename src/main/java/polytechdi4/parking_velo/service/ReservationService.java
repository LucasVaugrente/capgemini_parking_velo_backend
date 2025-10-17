package polytechdi4.parking_velo.service;

import polytechdi4.parking_velo.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    List<ReservationDTO> findAll();
    ReservationDTO findById(Integer utilisateurId, Integer veloId);
    ReservationDTO create(ReservationDTO dto);
    ReservationDTO update(Integer utilisateurId, Integer veloId, ReservationDTO dto);
    void delete(Integer utilisateurId, Integer veloId);
}


