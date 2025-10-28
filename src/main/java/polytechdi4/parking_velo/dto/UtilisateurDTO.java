package polytechdi4.parking_velo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UtilisateurDTO {
    private Long id;
    @NotBlank private String nom;
    @Email    private String email;
}