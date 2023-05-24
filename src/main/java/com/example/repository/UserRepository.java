package com.example.repository;

import com.example.entity.User;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

    UUID findUserIdByUsername(String name);
}
