package polytechdi4.parking_velo.mapper;

import org.mapstruct.Mapper;
import polytechdi4.parking_velo.dto.UtilisateurDTO;
import polytechdi4.parking_velo.model.Utilisateur;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurDTO toDto(Utilisateur entity);
    Utilisateur toEntity(UtilisateurDTO dto);
}
