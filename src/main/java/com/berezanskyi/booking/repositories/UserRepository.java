package com.berezanskyi.booking.repositories;

import com.berezanskyi.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> deleteByLogin(String name);

    Optional<User> findByLogin(String name);


}
