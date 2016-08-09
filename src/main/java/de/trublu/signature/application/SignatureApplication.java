package de.trublu.signature.application;

import de.trublu.signature.Rest.SignatureHealthCheck;
import de.trublu.signature.Rest.SignatureResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SignatureApplication extends Application<SignatureConfiguration> {
    public static void main(String[] args) throws Exception {
        new SignatureApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<SignatureConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(SignatureConfiguration configuration,
                    Environment environment) {
        final SignatureResource signatureResource = new SignatureResource();
        environment.jersey().register(signatureResource);
        final SignatureHealthCheck healthCheck = new SignatureHealthCheck();
        environment.healthChecks().register("template", healthCheck);
    }

}