package polytechdi4.parking_velo.service;

import polytechdi4.parking_velo.dto.UtilisateurDTO;

import java.util.List;


public interface UtilisateurService {
    List<UtilisateurDTO> findAll();
    UtilisateurDTO findById(Integer id);
    UtilisateurDTO create(UtilisateurDTO dto);
    UtilisateurDTO update(Integer id, UtilisateurDTO dto);
    void delete(Integer id);
}