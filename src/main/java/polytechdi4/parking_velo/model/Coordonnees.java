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
@Table(name = "coordonnees")
public class Coordonnees {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100) private String latitude;
    @Column(nullable = false, length = 100) private String longitude;

    @OneToOne(mappedBy = "coordonnees")
    private Velo velo;

}