package polytechdi4.parking_velo.mapper;

import org.mapstruct.*;
import polytechdi4.parking_velo.dto.UtilisateurDTO;
import polytechdi4.parking_velo.model.Utilisateur;


@Mapper(componentModel = "spring")
public interface UtilisateurMapper {
    UtilisateurDTO toDTO(Utilisateur utilisateur);

    @Mapping(target = "password", ignore = true)
    Utilisateur toEntity(UtilisateurDTO dto);

    @Mapping(target = "password", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Utilisateur utilisateur, UtilisateurDTO utilisateurDTO);

    @Mapping(target = "password", ignore = true)
    void fullUpdate(@MappingTarget Utilisateur utilisateur, UtilisateurDTO utilisateurDTO);
}
