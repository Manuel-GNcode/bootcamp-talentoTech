package com.energia.api.controller;

import org.springframework.web.bind.annotation.*;

import com.energia.api.model.Country;
import com.energia.api.service.CountryService;

import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import java.util.List;
@RestController
@RequestMapping("/api/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping
    public ResponseEntity<Country> create(@RequestBody Country country) {
        return ResponseEntity.ok(countryService.save(country));
    }

    @GetMapping
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable Long id) {
        return ResponseEntity.ok(countryService.findById(id));
    }
}

