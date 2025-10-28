package polytechdi4.parking_velo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReservationDTO {
    private Long id;
    @NotNull private Long utilisateurId;   // référence vers Utilisateur
    @NotNull private Long veloId;          // référence vers Velo
    @NotNull private LocalDateTime debut;
    @NotNull private LocalDateTime fin;
}