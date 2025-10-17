package polytechdi4.parking_velo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytechdi4.parking_velo.dto.UtilisateurDTO;
import polytechdi4.parking_velo.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService service;

    @GetMapping
    public List<UtilisateurDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UtilisateurDTO getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public UtilisateurDTO create(@RequestBody UtilisateurDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public UtilisateurDTO update(@PathVariable Integer id, @RequestBody UtilisateurDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
