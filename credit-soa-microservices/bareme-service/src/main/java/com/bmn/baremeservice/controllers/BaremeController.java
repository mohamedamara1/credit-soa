package com.bmn.baremeservice.controllers;

import com.bmn.baremeservice.model.Bareme;
import com.bmn.baremeservice.service.BaremeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bareme")
public class BaremeController {
    @Autowired
    private BaremeService baremeService;

    @PostMapping
    public ResponseEntity<Bareme> createBareme(@RequestBody Bareme bareme) {
        Bareme savedBareme = baremeService.createBareme(bareme);
        return new ResponseEntity<>(savedBareme, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<Bareme>> getAllBaremes() {
        List<Bareme> baremes = baremeService.getAllBaremes();
        return new ResponseEntity<>(baremes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bareme> getBaremeById(@PathVariable Long id) {
        Optional<Bareme> bareme = baremeService.getBaremeById(id);
        return bareme.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBareme(@PathVariable Long id) {
        Optional<Bareme> bareme = baremeService.getBaremeById(id);
        if (bareme.isPresent()) {
            baremeService.deleteBareme(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/select")
    public ResponseEntity<Bareme> selectBestBareme(@RequestParam double montant, @RequestParam int duree) {
        Bareme bestBareme = baremeService.selectBestBareme(montant, duree);
        return bestBareme != null ? new ResponseEntity<>(bestBareme, HttpStatus.OK) :
                ResponseEntity.notFound().build();
    }
}
