package polytechdi4.parking_velo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polytechdi4.parking_velo.dto.VeloDTO;
import polytechdi4.parking_velo.service.VeloService;

import java.util.List;

@RestController
@RequestMapping("/api/velos")
@RequiredArgsConstructor
public class VeloController {

    private final VeloService service;

    @GetMapping
    public List<VeloDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VeloDTO getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public VeloDTO create(@RequestBody VeloDTO dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public VeloDTO update(@PathVariable Integer id, @RequestBody VeloDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
