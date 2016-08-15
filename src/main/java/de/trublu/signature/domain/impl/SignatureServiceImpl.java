package de.trublu.signature.domain.impl;

import de.trublu.signature.domain.SignatureService;

public class SignatureServiceImpl implements SignatureService {
    @Override
    public String get() {
        return "--\n" +
            "In einer Irrsinnigen Welt vernuenftig\n" +
            "sein zu wollen, ist schon wieder ein Irrsinn fuer sich.\n" +
            "- Voltaire\n";
    }
}
