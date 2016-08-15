package de.trublu.signature

import de.trublu.signature.application.SignatureApplication
import de.trublu.signature.application.SignatureConfiguration
import groovyx.net.http.ContentType
import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import io.dropwizard.testing.ConfigOverride
import io.dropwizard.testing.DropwizardTestSupport
import io.dropwizard.testing.ResourceHelpers
import spock.lang.Specification

class SignatureResourceSpec extends Specification {

    public static final DropwizardTestSupport<SignatureConfiguration> SUPPORT =
            new DropwizardTestSupport<SignatureConfiguration>(SignatureApplication.class,
                    ResourceHelpers.resourceFilePath("signature.yaml"),
                    ConfigOverride.config("server.connector.port", "0")
            );

    def setup() {
        SUPPORT.before()
    }

    def "get static signature"() {
        setup:
            def client = new RESTClient("http://localhost:" +  SUPPORT.getLocalPort())
        when:
            def response = client.get(path: "/application/signature") as HttpResponseDecorator
        then:
            response.status == 200
            response.contentType == ContentType.JSON.toString()
            response.data.text == "-- \na .signature"
    }

    def "get ADMIN/healtcheck"() {
        setup:
            def client = new RESTClient("http://localhost:" +  SUPPORT.getAdminPort())
        when:
            def response = client.get(path: "/admin/healthcheck") as HttpResponseDecorator
        then:
            response.status == 200
            response.contentType == ContentType.JSON.toString()
    }
}
