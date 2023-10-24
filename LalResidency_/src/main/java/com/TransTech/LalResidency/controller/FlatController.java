package com.TransTech.LalResidency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TransTech.LalResidency.entity.Flat;
import com.TransTech.LalResidency.service.FlatService;

@RestController
@RequestMapping("/api/flat")
public class FlatController {

	@Autowired
	private FlatService flatService;
	
    @GetMapping("/{flatId}")
    public ResponseEntity<Flat> getFlatById(@PathVariable Long flatId) {
        Flat flat = flatService.getFlatById(flatId);
        if (flat != null) {
            return new ResponseEntity<>(flat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/property/{propertyId}")
    public ResponseEntity<List<Flat>> getFlatsByProperty(@PathVariable Long propertyId) {
        List<Flat> flats = flatService.getFlatsByProperty(propertyId);
        return new ResponseEntity<>(flats, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flat> createFlat(@RequestBody Flat flat) {
        Flat createdFlat = flatService.addFlat(flat);
        return new ResponseEntity<>(createdFlat, HttpStatus.CREATED);
    }

    @PutMapping("/{flatId}")
    public ResponseEntity<Flat> updateFlat(@PathVariable Long flatId, @RequestBody Flat flat) {
        Flat updatedFlat = flatService.updateFlat(flatId, flat);
        if (updatedFlat != null) {
            return new ResponseEntity<>(updatedFlat, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{flatId}")
    public ResponseEntity<Void> deleteFlat(@PathVariable Long flatId) {
        boolean deleted = flatService.deleteFlat(flatId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add more endpoints for flat-related actions
}
