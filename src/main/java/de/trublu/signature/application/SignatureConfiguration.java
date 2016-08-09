package de.trublu.signature.application;

import io.dropwizard.Configuration;
import lombok.Getter;
import lombok.Setter;

public class SignatureConfiguration extends Configuration {
    @Getter
    @Setter
    String defaultName;
}
