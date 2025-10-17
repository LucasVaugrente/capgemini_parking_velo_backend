package polytechdi4.parking_velo.mapper;

import org.mapstruct.*;
import polytechdi4.parking_velo.dto.ReservationDTO;
import polytechdi4.parking_velo.model.Reservation;
import polytechdi4.parking_velo.model.Utilisateur;
import polytechdi4.parking_velo.model.Velo;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "velo", target = "veloId")
    @Mapping(source = "utilisateur", target = "utilisateurId")
    ReservationDTO toDTO(Reservation reservation);


    @Mapping(source = "veloId", target = "velo")
    @Mapping(source = "utilisateurId", target = "utilisateur")
    Reservation toEntity(ReservationDTO dto);

    @Mapping(source = "veloId", target = "velo")
    @Mapping(source = "utilisateurId", target = "utilisateur")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget Reservation reservation, ReservationDTO reservationDTO);

    @Mapping(source = "veloId", target = "velo")
    @Mapping(source = "utilisateurId", target = "utilisateur")
    void fullUpdate(@MappingTarget Reservation reservation, ReservationDTO reservationDTO);

    default Integer map(Utilisateur utilisateur) {
        return utilisateur == null ? null : utilisateur.getId();
    }

    default Integer map(Velo velo) {
        return velo == null ? null : velo.getId();
    }

    default Utilisateur mapUtilisateur(Integer utilisateurId) {
        if (utilisateurId == null) return null;

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurId);

        return utilisateur;
    }

    default Velo mapVelo(Integer veloId) {
        if (veloId == null) return null;

        Velo velo = new Velo();
        velo.setId(veloId);

        return velo;
    }


}
