package com.countiesenergy.users.takehometest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.countiesenergy.users.takehometest.model.User;
import java.util.List;

/**
 * Repository interface interface that provides the funtional interface to the
 * persistance layer
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByLastName(String lastName);
}
