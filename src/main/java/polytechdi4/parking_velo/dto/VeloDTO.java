package polytechdi4.parking_velo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeloDTO {
    private Integer id;
    private String nom;
    private Integer quantite;
    private String description;
    private Integer coordonneesId;
}
