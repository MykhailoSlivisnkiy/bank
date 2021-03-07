package com.bank.application.repository;

import com.bank.application.model.User;
import com.bank.application.model.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByRoles(Role role);
    Optional<User> findAllByUsername(String username);
    Optional<User> findUserByLastName(String name);
}
