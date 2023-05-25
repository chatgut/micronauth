package com.example.security;

import com.example.repository.UserRepository;
import com.example.service.UserService;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Map;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {


    UserRepository repository;

    UserService userService;

    public AuthenticationProviderUserPassword(UserRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flux.create(emitter -> {
            String username = authenticationRequest.getIdentity().toString();
            String password = authenticationRequest.getSecret().toString();
            boolean isValid = userService.validCredentials(username,password);
            if (isValid) {
                emitter.next(AuthenticationResponse.success(username, Map.of(
                        "sub", repository.findByUsername(username).getUserId(),
                        "iss", "micronauth")));
                emitter.complete();
            } else {
                emitter.error(AuthenticationResponse.exception());
            }
        }, FluxSink.OverflowStrategy.ERROR);
    }
}
