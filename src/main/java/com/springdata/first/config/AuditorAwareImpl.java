package com.springdata.first.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
       // Authentication authentication= //SecurityContextHolder.getContext().getAuthentication();

        return Optional.of("test user");
    }
}
