package com.example.security.keypair;

import com.nimbusds.jose.JOSEException;
import io.micronaut.core.annotation.NonNull;

public interface JwkConfiguration {

    @NonNull
    String getPrimary() throws JOSEException;

    @NonNull
    String getSecondary() throws JOSEException;
}
