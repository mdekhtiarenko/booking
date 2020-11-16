package com.berezanskyi.booking.repositories;

import com.berezanskyi.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    long deleteByLogin(String login);

    Optional<User> findByLogin(String login);




}
