package polytechdi4.parking_velo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VeloDTO {
    private Integer id;
    @NotBlank private String nom;
    @NotBlank private Integer quantite;
    @NotBlank private String description;
}