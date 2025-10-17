package polytechdi4.parking_velo.mapper;

import org.mapstruct.*;
import polytechdi4.parking_velo.dto.CoordonneesDTO;
import polytechdi4.parking_velo.model.Coordonnees;

@Mapper(componentModel = "spring")
public interface CoordonneesMapper {
    CoordonneesDTO toDTO(Coordonnees coordonnees);

    @Mapping(target = "velo", ignore = true)
    Coordonnees toEntity(CoordonneesDTO dto);

    @Mapping(target = "velo", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Coordonnees coordonnees, CoordonneesDTO coordonneesDTO);

    @Mapping(target = "velo", ignore = true)
    void fullUpdate(@MappingTarget Coordonnees coordonnees, CoordonneesDTO coordonneesDTO);
}
