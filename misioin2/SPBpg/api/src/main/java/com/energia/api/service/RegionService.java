package com.energia.api.service;


import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.energia.api.model.Country;
import com.energia.api.model.Region;
import com.energia.api.repository.CountryRepository;
import com.energia.api.repository.RegionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    public Region save(Region region) {
        Long countryId = region.getCountry().getId();
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Country not found"));
        if (regionRepository.existsByNameAndCountryId(region.getName(), countryId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Region already exists in this country");
        }
        region.setCountry(country);
        return regionRepository.save(region);
    }

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Region findById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Region not found"));
    }

    public List<Region> findByCountry(Long countryId) {
        return regionRepository.findByCountryId(countryId);
    }
}
