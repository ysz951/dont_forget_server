package com.dont.forget.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dont.forget.exception.ForbiddenException;
import com.dont.forget.exception.ResourceNotFoundException;
import com.dont.forget.model.Item;
import com.dont.forget.model.ItemList;
import com.dont.forget.payload.ApiResponse;
import com.dont.forget.repository.ItemListRepository;
import com.dont.forget.repository.ItemRepository;
import com.dont.forget.repository.UserRepository;
import com.dont.forget.security.UserPrincipal;

@Service
public class ItemListService {

    @Autowired
    private ItemListRepository itemListRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    public ItemList findById(long id, UserPrincipal currentUser) {
        ItemList itemList = itemListRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("list", "id", id));
        if (itemList.getUser() == null || itemList.getUser().getId() != currentUser.getId()) {
            throw new ForbiddenException("No permit");
        }
        return itemList;
    }

    public ResponseEntity<?> saveList(ItemList itemList, UserPrincipal currentUser) {
        itemList.setUser(userRepository.findById(currentUser.getId()).get());
        itemListRepository.save(itemList);
        return new ResponseEntity<>(new ApiResponse(true, "Save list successfully"), HttpStatus.CREATED);
    }

    public List<ItemList> getAllList(UserPrincipal currentUser) {
        List<ItemList> itemList = itemListRepository.findByUserId(currentUser.getId());
        return itemList;
    }

    public ResponseEntity<?> saveItem(long listId, Item item, UserPrincipal currentUser) {
        ItemList itemList = findById(listId, currentUser);
        item.setList(itemList);
        item.setUser(userRepository.findById(currentUser.getId()).get());
        itemRepository.save(item);
        return new ResponseEntity<>(new ApiResponse(true, "Save item successfully"), HttpStatus.CREATED);
    }

    public Item getListItemById(long listId, long itemId, UserPrincipal currentUser) {
        Item item = itemRepository.findByListIdAndUserId(currentUser.getId(), listId, itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));
        return item;
    }

    public List<Item> getListItems(long listId, UserPrincipal currentUser) {
        ItemList itemList = findById(listId, currentUser);
        return itemList.getListItems();
    }

}
