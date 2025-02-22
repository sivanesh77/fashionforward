package com.fashionforward.controller;

import com.fashionforward.entity.ClothingItem;
import com.fashionforward.service.ClothingItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloth")
public class ClothingItemController {
    private final ClothingItemService clothingItemService;

    public ClothingItemController(ClothingItemService clothingItemService) {
        this.clothingItemService = clothingItemService;
    }

    @GetMapping
    public ResponseEntity<Page<ClothingItem>> getAllClothingItems(Pageable pageable) {
        return ResponseEntity.ok(clothingItemService.getAllClothingItems(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothingItem> getClothingItemById(@PathVariable Long id) {
        return ResponseEntity.ok(clothingItemService.getClothingItemById(id));
    }

    @PostMapping
    public ResponseEntity<ClothingItem> createClothingItem(@RequestBody ClothingItem clothingItem) {
        return ResponseEntity.status(201).body(clothingItemService.createClothingItem(clothingItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClothingItem> updateClothingItem(@PathVariable Long id, @RequestBody ClothingItem updatedClothingItem) {
        return ResponseEntity.ok(clothingItemService.updateClothingItem(id, updatedClothingItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothingItem(@PathVariable Long id) {
        clothingItemService.deleteClothingItem(id);
        return ResponseEntity.noContent().build();
    }
}
