package de.trublu.signature.domain

import de.trublu.signature.domain.impl.SignatureServiceImpl
import spock.lang.Specification

class SignatureServiceSpec extends Specification {

    def "return a static .signature"() {
        expect:
            new SignatureServiceImpl().get() ==
                    """--
                    |In einer Irrsinnigen Welt vernuenftig
                    |sein zu wollen, ist schon wieder ein Irrsinn fuer sich.
                    |- Voltaire
                    |""".stripMargin()
    }

}
