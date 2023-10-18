package br.com.fiap.postech.machinecheck.controller;

import br.com.fiap.postech.machinecheck.dto.CheckDTO;
import br.com.fiap.postech.machinecheck.service.CheckService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checagens")
public class CheckContoller {
    private final CheckService checkService;

    @Autowired
    public CheckContoller(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping
    public ResponseEntity<List<CheckDTO>> findAll() {
        List<CheckDTO> checks = checkService.findAll();
        return ResponseEntity.ok(checks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckDTO> findById(@PathVariable Long id) {
        CheckDTO check = checkService.findById(id);
        return ResponseEntity.ok(check);
    }

    @PostMapping
    public ResponseEntity<CheckDTO> save(@Valid @RequestBody CheckDTO checkDTO) {
        CheckDTO savedCheck = checkService.save(checkDTO);
        return new ResponseEntity<>(savedCheck, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CheckDTO> update(@PathVariable Long id, @Valid @RequestBody CheckDTO usuarioDTO) {
        CheckDTO updatedCheck = checkService.update(id, usuarioDTO);
        return ResponseEntity.ok(updatedCheck);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        checkService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
