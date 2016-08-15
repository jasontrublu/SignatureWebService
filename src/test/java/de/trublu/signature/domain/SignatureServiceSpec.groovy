package de.trublu.signature.domain

import de.trublu.signature.domain.impl.SignatureServiceImpl
import de.trublu.signature.repository.SignatureRepository
import spock.lang.Specification
import spock.lang.Unroll

class SignatureServiceSpec extends Specification {

    SignatureRepository repository = Mock()

    @Unroll
    def "get signature from repository with id=#testName"() {
        when:
            def result = new SignatureServiceImpl(repository).get(id)
        then:
            result == signature
            1 * repository.get(id) >> signature
        where:
            testName | id || signature
            "1"      | 1  || "signature 1"
            "2"      | 2  || "seconds signature"
            "5"      | 5  || "another sig"

    }
}
