package com.fashionforward.controller;

import com.fashionforward.entity.ClothingItem;
import com.fashionforward.service.ClothingItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloth")
@Tag(name = "Clothing Item Controller", description = "Manage clothing inventory")
public class ClothingItemController {
    private final ClothingItemService clothingItemService;

    public ClothingItemController(ClothingItemService clothingItemService) {
        this.clothingItemService = clothingItemService;
    }

    @GetMapping
    @Operation(summary = "Get all clothing items", description = "Fetch a paginated list of clothing items")
    @ApiResponse(responseCode = "200", description = "Clothing items retrieved successfully")
    public ResponseEntity<Page<ClothingItem>> getAllClothingItems(Pageable pageable) {
        return ResponseEntity.ok(clothingItemService.getAllClothingItems(pageable));
    }
}
