package com.dont.forget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dont.forget.exception.ResourceNotFoundException;
import com.dont.forget.model.Item;
import com.dont.forget.repository.ItemRepository;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item getById(long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "item", id));
        return item;
    }
}
