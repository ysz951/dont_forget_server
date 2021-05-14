package com.dont.forget.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dont.forget.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("select i from Item i where i.user.id = ?1 and i.list.id = ?2 and i.id = ?3")
    Optional<Item> findByListIdAndUserId(long userId, long listId, long itemId);
}
