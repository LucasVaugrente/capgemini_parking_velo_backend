package polytechdi4.parking_velo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "velo")
public class Velo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100) private String nom;
    @Column(nullable = false) private Integer quantite;
    @Column(length = 200) private String description;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "coordonnees_id", nullable = false)
    private Coordonnees coordonnees;

    @OneToMany(mappedBy = "velo", orphanRemoval = true)
    private Set<Reservation> reservations = new LinkedHashSet<>();

}