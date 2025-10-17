package polytechdi4.parking_velo.mapper;

import org.mapstruct.*;
import polytechdi4.parking_velo.dto.VeloDTO;
import polytechdi4.parking_velo.model.Coordonnees;
import polytechdi4.parking_velo.model.Velo;

@Mapper(componentModel = "spring")
public interface VeloMapper {
    @Mapping(source = "coordonnees", target = "coordonneesId")
    VeloDTO toDTO(Velo velo);
    @Mapping(source = "coordonneesId", target = "coordonnees")
    Velo toEntity(VeloDTO dto);

    @Mapping(source = "coordonneesId", target = "coordonnees")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Velo velo, VeloDTO veloDTO);

    @Mapping(source = "coordonneesId", target = "coordonnees")
    void fullUpdate(@MappingTarget Velo velo, VeloDTO veloDTO);

    default Integer map(Coordonnees coordonnees) {
        return coordonnees == null ? null : coordonnees.getId();
    }

    default Coordonnees map(Integer coordonneesId) {
        if (coordonneesId == null) return null;

        Coordonnees coordonnees = new Coordonnees();
        coordonnees.setId(coordonneesId);

        return coordonnees;
    }
}


