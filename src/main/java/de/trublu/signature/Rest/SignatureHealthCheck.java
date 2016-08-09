package de.trublu.signature.Rest;

import com.codahale.metrics.health.HealthCheck;

public class SignatureHealthCheck extends HealthCheck {

        @Override
        protected Result check() throws Exception {
            return Result.healthy();
        }
    }
