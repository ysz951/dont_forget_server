package com.dont.forget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dont.forget.exception.ForbiddenException;
import com.dont.forget.exception.ResourceNotFoundException;
import com.dont.forget.model.Item;
import com.dont.forget.payload.ApiResponse;
import com.dont.forget.repository.ItemRepository;
import com.dont.forget.security.UserPrincipal;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item getById(long id, UserPrincipal currentUser) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "item", id));
        if (item.getUser() == null || item.getUser().getId() != currentUser.getId()) {
            throw new ForbiddenException("No permit");
        }
        return item;
    }

    public ResponseEntity<?> deleteItem(long id, UserPrincipal currentUser) {
        Item item = getById(id, currentUser);
        itemRepository.delete(item);
        return ResponseEntity.ok(new ApiResponse(true, "Delete item"));
    }

    public ResponseEntity<?> updateItem(long id, UserPrincipal currentUser, String name) {
        Item item = getById(id, currentUser);
        item.setItemName(name);
        itemRepository.save(item);
        return ResponseEntity.ok(new ApiResponse(true, "Update item"));
    }
}
