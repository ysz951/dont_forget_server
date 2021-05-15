package com.dont.forget.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dont.forget.model.ItemList;
import com.dont.forget.model.Type;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {

    @Query("select il from ItemList il where il.user.id = ?1")
    List<ItemList> findByUserId(long userId);

    @Query("select il from ItemList il where il.user.id = ?1 and il.type = ?2")
    List<ItemList> findByUserIdAndType(long userId, Type type);
}
