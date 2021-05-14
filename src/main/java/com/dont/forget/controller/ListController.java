package com.dont.forget.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dont.forget.model.Item;
import com.dont.forget.model.ItemList;
import com.dont.forget.security.CurrentUser;
import com.dont.forget.security.UserPrincipal;
import com.dont.forget.service.ItemListService;

@RestController
@RequestMapping("/api/list")
public class ListController {

    @Autowired
    private ItemListService itemListService;

    @GetMapping
    public List<ItemList> getAllList(@CurrentUser UserPrincipal currentUser) {
        return itemListService.getAllList(currentUser);
    }

    @PostMapping
    public ResponseEntity<?> saveList(@RequestBody @Valid ItemList itemList, @CurrentUser UserPrincipal currentUser) {
        return itemListService.saveList(itemList, currentUser);
    }

    @GetMapping("/{id}")
    public ItemList getById(@PathVariable("id") long id, @CurrentUser UserPrincipal currentUser) {
        return itemListService.findById(id, currentUser);
    }

    @PostMapping("/{id}/item")
    public ResponseEntity<?> saveItemToList(
            @PathVariable("id") long id,
            @CurrentUser UserPrincipal currentUser,
            @RequestBody @Valid Item item) {
        return itemListService.saveItem(id, item, currentUser);
    }

    @GetMapping("/{id}/item")
    public List<Item> getListItem(
            @PathVariable("id") long id,
            @CurrentUser UserPrincipal currentUser) {
        return itemListService.getListItems(id, currentUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id, @CurrentUser UserPrincipal currentUser) {
        return itemListService.deleteList(id, currentUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") long id, @CurrentUser UserPrincipal currentUser, @RequestParam("name") String name) {
        return itemListService.updateList(id, currentUser, name);
    }

}
