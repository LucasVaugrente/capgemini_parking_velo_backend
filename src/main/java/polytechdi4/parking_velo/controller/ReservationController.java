package polytechdi4.parking_velo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytechdi4.parking_velo.dto.ReservationDTO;
import polytechdi4.parking_velo.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService service;

    @GetMapping
    public List<ReservationDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{utilisateurId}/{veloId}")
    public ReservationDTO getById(@PathVariable Integer utilisateurId,
                                  @PathVariable Integer veloId) {
        return service.findById(utilisateurId, veloId);
    }

    @PostMapping
    public ReservationDTO create(@RequestBody ReservationDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{utilisateurId}/{veloId}")
    public ReservationDTO update(@PathVariable Integer utilisateurId,
                                 @PathVariable Integer veloId,
                                 @RequestBody ReservationDTO dto) {
        return service.update(utilisateurId, veloId, dto);
    }

    @DeleteMapping("/{utilisateurId}/{veloId}")
    public ResponseEntity<Void> delete(@PathVariable Integer utilisateurId,
                                       @PathVariable Integer veloId) {
        service.delete(utilisateurId, veloId);
        return ResponseEntity.noContent().build();
    }
}
