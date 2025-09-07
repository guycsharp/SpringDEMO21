package com.example.SpringJava21.controller;

import com.example.SpringJava21.entity.CharacterEntity;
import com.example.SpringJava21.repository.CharacterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterRepository repo;

    public CharacterController(CharacterRepository repo) {
        this.repo = repo;
    }

    // GET  /characters
    @GetMapping
    public List<CharacterEntity> listAll() {
        return repo.findAll();
    }

    // GET  /characters/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CharacterEntity> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /characters
    @PostMapping
    public CharacterEntity create(@RequestBody CharacterEntity character) {
        LocalDateTime now = LocalDateTime.now();
        character.setInsertedDate(now);
        character.setUpdateDate(now);
        return repo.save(character);
    }

    // PUT  /characters/{id}
    @PutMapping("/{id}")
    public ResponseEntity<CharacterEntity> update(
            @PathVariable Long id,
            @RequestBody CharacterEntity updated) {

        return repo.findById(id).map(existing -> {
            existing.setFullName(updated.getFullName());
            existing.setFaction(updated.getFaction());
            existing.setPic(updated.getPic());
            existing.setType(updated.getType());
            existing.setAllegiance(updated.getAllegiance());
            existing.setUpdateDate(LocalDateTime.now());
            CharacterEntity saved = repo.save(existing);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /characters/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
