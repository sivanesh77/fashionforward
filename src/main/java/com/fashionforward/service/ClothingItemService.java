package com.fashionforward.service;

import com.fashionforward.entity.ClothingItem;
import com.fashionforward.repository.ClothingItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClothingItemService {
    private final ClothingItemRepository clothingItemRepository;

    public ClothingItemService(ClothingItemRepository clothingItemRepository) {
        this.clothingItemRepository = clothingItemRepository;
    }

    public Page<ClothingItem> getAllClothingItems(Pageable pageable) {
        return clothingItemRepository.findAll(pageable);
    }

    public ClothingItem getClothingItemById(Long id) {
        return clothingItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clothing item not found"));
    }

    public ClothingItem createClothingItem(ClothingItem clothingItem) {
        return clothingItemRepository.save(clothingItem);
    }

    public ClothingItem updateClothingItem(Long id, ClothingItem updatedClothingItem) {
        ClothingItem existingItem = getClothingItemById(id);
        existingItem.setName(updatedClothingItem.getName());
        existingItem.setSize(updatedClothingItem.getSize());
        existingItem.setBrand(updatedClothingItem.getBrand());
        existingItem.setCategory(updatedClothingItem.getCategory());
        existingItem.setPrice(updatedClothingItem.getPrice());
        return clothingItemRepository.save(existingItem);
    }

    public void deleteClothingItem(Long id) {
        clothingItemRepository.deleteById(id);
    }
}
