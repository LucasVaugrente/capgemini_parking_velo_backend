package polytechdi4.parking_velo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CoordonneesDTO {
    private Integer id;
    @NotBlank private String latitude;
    @NotBlank private String longitude;
}
