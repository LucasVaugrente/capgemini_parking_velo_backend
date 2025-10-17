package polytechdi4.parking_velo.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReservationId implements Serializable {
    private Integer utilisateurId;
    private Integer veloId;
    @Override public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof ReservationId that)) return false;
        return Objects.equals(utilisateurId, that.utilisateurId)
                && Objects.equals(veloId, that.veloId);
    }
    @Override public int hashCode(){ return Objects.hash(utilisateurId, veloId); }
}