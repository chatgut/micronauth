package com.example.repository;

import com.example.entity.RefreshTokenEntity;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshTokenEntity, Long> {

    Optional<RefreshTokenEntity> findByRefreshToken(@NonNull @NotBlank String refreshToken);

    void updateByUsername(@NonNull @NotBlank String username, String refreshToken, Instant dateCreated, boolean revoked);

    boolean existsByUsername(@NonNull @NotBlank String username);
}
