package com.fashionforward.service;

import com.fashionforward.entity.Rental;
import com.fashionforward.repository.RentalRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    // ✅ Get all rentals with pagination
    public Page<Rental> getAllRentals(Pageable pageable) {
        return rentalRepository.findAll(pageable);
    }

    // ✅ Get rental by ID
    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental not found"));
    }

    // ✅ Create a new rental
    public Rental createRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    // ✅ Update an existing rental
    public Rental updateRental(Long id, Rental updatedRental) {
        Rental existingRental = getRentalById(id);
        existingRental.setRentalDate(updatedRental.getRentalDate());
        existingRental.setReturnDate(updatedRental.getReturnDate());
        existingRental.setStatus(updatedRental.getStatus());
        return rentalRepository.save(existingRental);
    }

    // ✅ Delete a rental
    public void deleteRental(Long id) {
        rentalRepository.deleteById(id);
    }
}
