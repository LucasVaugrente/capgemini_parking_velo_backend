package polytechdi4.parking_velo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import polytechdi4.parking_velo.dto.UtilisateurDTO;
import polytechdi4.parking_velo.service.UtilisateurService;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@RequiredArgsConstructor
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UtilisateurDTO create(@Valid @RequestBody UtilisateurDTO dto) {
        return utilisateurService.create(dto);
    }

    @GetMapping
    public List<UtilisateurDTO> getAll() {
        return utilisateurService.list();
    }

    @GetMapping("/{id}")
    public UtilisateurDTO getById(@PathVariable Long id) {
        return utilisateurService.get(id);
    }

    @PutMapping("/{id}")
    public UtilisateurDTO update(@PathVariable Long id,
                                 @Valid @RequestBody UtilisateurDTO dto) {
        return utilisateurService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        utilisateurService.delete(id);
    }
}