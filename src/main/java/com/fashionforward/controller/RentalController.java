package com.fashionforward.controller;

import com.fashionforward.entity.Rental;
import com.fashionforward.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rentals")
@Tag(name = "Rental Controller", description = "Manage rental transactions")
public class RentalController {
    private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    @Operation(summary = "Get all rentals", description = "Fetch a paginated list of rentals")
    @ApiResponse(responseCode = "200", description = "Rentals retrieved successfully")
    public ResponseEntity<Page<Rental>> getAllRentals(Pageable pageable) {
        return ResponseEntity.ok(rentalService.getAllRentals(pageable));
    }
}
