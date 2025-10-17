package polytechdi4.parking_velo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {

    @EmbeddedId
    private ReservationId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("utilisateurId")
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("veloId")
    @JoinColumn(name = "velo_id", nullable = false)
    private Velo velo;

    @Column(name = "reservation", nullable = false)
    private Integer reservation;

    public Reservation(Utilisateur utilisateur, Velo velo, Integer reservation) {
        this.utilisateur = utilisateur;
        this.velo = velo;
        this.id = new ReservationId(utilisateur.getId(), velo.getId());
        this.reservation = reservation;
    }

}