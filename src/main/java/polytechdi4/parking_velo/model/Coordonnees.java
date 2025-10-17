package polytechdi4.parking_velo.model;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "coordonnees")
public class Coordonnees {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100) private String latitude;
    @Column(nullable = false, length = 100) private String longitude;

    @OneToMany(mappedBy = "coordonnees")
    private Set<Velo> velos = new LinkedHashSet<>();

    // getters/setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public Set<Velo> getVelos() { return velos; }
    public void setVelos(Set<Velo> velos) { this.velos = velos; }
}
