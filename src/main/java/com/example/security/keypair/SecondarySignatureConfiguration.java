package com.example.security.keypair;

import com.nimbusds.jose.JOSEException;
import io.micronaut.runtime.context.scope.Refreshable;

@Refreshable
public class SecondarySignatureConfiguration extends AbstractRSASignatureConfiguration{

    public SecondarySignatureConfiguration(JwkConfiguration jwkConfiguration) throws JOSEException {
        super(jwkConfiguration.getSecondary());
    }
}
