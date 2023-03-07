package com.codecool.liase_and_direct.repos;

import com.codecool.liase_and_direct.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository of User. Because it extends JpaRepository no implementation is needed.
 * Model: typeOfMethiod 'keyWord''fieldFromClass'(parameter type)
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
