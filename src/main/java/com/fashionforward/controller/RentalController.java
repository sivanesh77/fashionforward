package com.fashionforward.controller;

import com.fashionforward.entity.Rental;
import com.fashionforward.service.RentalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

   
    @GetMapping
    public ResponseEntity<Page<Rental>> getAllRentals(Pageable pageable) {
        return ResponseEntity.ok(rentalService.getAllRentals(pageable));
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getRentalById(id));
    }

    // ✅ Create a new rental
    @PostMapping
    public ResponseEntity<Rental> createRental(@RequestBody Rental rental) {
        return ResponseEntity.status(201).body(rentalService.createRental(rental));
    }

    // ✅ Update an existing rental
    @PutMapping("/{id}")
    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @RequestBody Rental updatedRental) {
        return ResponseEntity.ok(rentalService.updateRental(id, updatedRental));
    }

    // ✅ Delete a rental
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
        return ResponseEntity.noContent().build();
    }
}
