package com.dont.forget.model;

import java.util.Set;

public class ItemListResponse {

    private String listName;

    private Set<Item> listItems;

    public ItemListResponse() {

    }

    public ItemListResponse(String listName, Set<Item> listItems) {
        this.listName = listName;
        this.listItems = listItems;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public Set<Item> getListItems() {
        return listItems;
    }

    public void setListItems(Set<Item> listItems) {
        this.listItems = listItems;
    }


}
