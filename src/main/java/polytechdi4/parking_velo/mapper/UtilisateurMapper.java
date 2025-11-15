package polytechdi4.parking_velo.mapper;

import org.mapstruct.Mapper;
import polytechdi4.parking_velo.dto.UtilisateurCreateDTO;
import polytechdi4.parking_velo.dto.UtilisateurResponseDTO;
import polytechdi4.parking_velo.model.Utilisateur;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurResponseDTO toResponseDto(Utilisateur entity);
    List<UtilisateurResponseDTO> toResponseDtoList(List<Utilisateur> entities);
    Utilisateur toEntity(UtilisateurCreateDTO dto);
}
