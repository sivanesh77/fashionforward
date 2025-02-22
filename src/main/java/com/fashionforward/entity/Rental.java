package com.fashionforward.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate rentalDate;
    private LocalDate returnDate;
    private String status;

    // Constructors
    public Rental() {
    }

    public Rental(LocalDate rentalDate, LocalDate returnDate, String status) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // toString method (optional, but useful for debugging)
    @Override
    public String toString() {
        return "Rental{id=" + id + ", rentalDate=" + rentalDate + ", returnDate=" + returnDate + ", status='" + status + "'}";
    }
}
