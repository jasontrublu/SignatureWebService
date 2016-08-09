package de.trublu.signature

import de.trublu.signature.application.SignatureApplication
import de.trublu.signature.application.SignatureConfiguration
import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import io.dropwizard.testing.DropwizardTestSupport
import io.dropwizard.testing.ResourceHelpers
import spock.lang.Specification

class SignatureResourceSpec extends Specification {

    public static final DropwizardTestSupport<SignatureConfiguration> SUPPORT =
            new DropwizardTestSupport<SignatureConfiguration>(SignatureApplication.class,
                    ResourceHelpers.resourceFilePath("signature.yaml")
            );

    def setup() {
        SUPPORT.before()
    }

    def "get static signature"() {
        setup:
            def client = new RESTClient("http://localhost:" + "8080")// RULE.getLocalPort())
        when:
            def response = client.get(path: "/signature") as HttpResponseDecorator
        then:
            response.status == 200
            response.contentType == ContentType.JSON.toString()
            response.data.text == "-- \na .signature"
    }
}
