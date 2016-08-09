package de.trublu.signature.Rest.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SignatureResponse {

    @JsonProperty
    String text;
}
