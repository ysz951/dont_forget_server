package com.dont.forget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dont.forget.model.Item;
import com.dont.forget.security.CurrentUser;
import com.dont.forget.security.UserPrincipal;
import com.dont.forget.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/{id}")
    public Item findById(@PathVariable long id, @CurrentUser UserPrincipal currentUser) {
        return itemService.getById(id, currentUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByid(@PathVariable long id, @CurrentUser UserPrincipal currentUser) {
        return itemService.deleteItem(id, currentUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable long id, @CurrentUser UserPrincipal currentUser, @RequestParam("name") String name) {
        return itemService.updateItem(id, currentUser, name);
    }

}
