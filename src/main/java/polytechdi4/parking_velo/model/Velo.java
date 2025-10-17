package polytechdi4.parking_velo.model;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "velo")
public class Velo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100) private String nom;
    @Column(nullable = false) private Integer quantite;
    @Column(length = 200) private String description;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "coordonnees_id", nullable = false)
    private Coordonnees coordonnees;

    @OneToMany(mappedBy = "velo", orphanRemoval = true)
    private Set<Reservation> reservations = new LinkedHashSet<>();

    // getters/setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public Integer getQuantite() { return quantite; }
    public void setQuantite(Integer quantite) { this.quantite = quantite; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Coordonnees getCoordonnees() { return coordonnees; }
    public void setCoordonnees(Coordonnees coordonnees) { this.coordonnees = coordonnees; }
    public Set<Reservation> getReservations() { return reservations; }
    public void setReservations(Set<Reservation> reservations) { this.reservations = reservations; }
}
