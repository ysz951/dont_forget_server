package com.dont.forget.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dont.forget.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUserName(String userName);

    Boolean existsByUserName(String userName);
}
