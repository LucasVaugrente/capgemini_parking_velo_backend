package polytechdi4.parking_velo.mapper;

import org.mapstruct.*;
import polytechdi4.parking_velo.dto.ReservationDTO;
import polytechdi4.parking_velo.model.Reservation;
import polytechdi4.parking_velo.model.Utilisateur;
import polytechdi4.parking_velo.model.Velo;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "utilisateurId", source = "utilisateur.id")
    @Mapping(target = "veloId", source = "velo.id")
    ReservationDTO toDto(Reservation entity);

    // Pour créer l’entité à partir d’ids présents dans le DTO,
    // on mappe vers des "stubs" d’entités avec uniquement l’id.
    @Mapping(target = "utilisateur", source = "utilisateurId")
    @Mapping(target = "velo", source = "veloId")
    Reservation toEntity(ReservationDTO dto);

    default Utilisateur mapUtilisateur(Long id) {
        if (id == null) return null;
        Utilisateur u = new Utilisateur();
        u.setId(Math.toIntExact(id));
        return u;
    }

    default Velo mapVelo(Long id) {
        if (id == null) return null;
        Velo v = new Velo();
        v.setId(Math.toIntExact(id));
        return v;
    }
}