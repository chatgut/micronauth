package com.example.security.keypair;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;

import java.util.Date;
import java.util.UUID;

import static com.nimbusds.jose.JWSAlgorithm.RS256;

@Singleton
public class JwkConfigurationProperties implements JwkConfiguration {

    @Override
    @NonNull
    public String getPrimary() throws JOSEException {
        return generateRsaKey().toJSONString();
    }

    @Override
    @NonNull
    public String getSecondary() throws JOSEException {
        return generateRsaKey().toJSONString();
    }

    private static RSAKey generateRsaKey() throws JOSEException {
        return new RSAKeyGenerator(2048)
                .algorithm(RS256)
                .keyUse(KeyUse.SIGNATURE)
                .keyID(UUID.randomUUID().toString())
                .issueTime(new Date())
                .generate();
    }
}
