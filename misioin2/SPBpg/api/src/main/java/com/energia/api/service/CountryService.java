package com.energia.api.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.energia.api.model.Country;
import com.energia.api.repository.CountryRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country save(Country country) {

        if (countryRepository.existsByName(country.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"el país ya existe");
        }

        return countryRepository.save(country);
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"País no encontrado"));
    }
}
