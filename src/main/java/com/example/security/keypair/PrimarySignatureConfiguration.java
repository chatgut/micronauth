package com.example.security.keypair;

import com.nimbusds.jose.JOSEException;
import io.micronaut.runtime.context.scope.Refreshable;
import jakarta.inject.Named;

@Refreshable
@Named("generator")
public class PrimarySignatureConfiguration extends AbstractRSAGeneratorSignatureConfiguration{

    public PrimarySignatureConfiguration(JwkConfiguration jwkConfiguration) throws JOSEException {
        super(jwkConfiguration.getPrimary());
    }
}
