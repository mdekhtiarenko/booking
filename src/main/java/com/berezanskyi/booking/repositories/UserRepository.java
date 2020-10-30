package com.berezanskyi.booking.repositories;

import com.berezanskyi.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
