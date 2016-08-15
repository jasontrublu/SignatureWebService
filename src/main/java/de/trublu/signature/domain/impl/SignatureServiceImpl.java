package de.trublu.signature.domain.impl;

import de.trublu.signature.domain.SignatureService;
import de.trublu.signature.repository.SignatureRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SignatureServiceImpl implements SignatureService {

    final SignatureRepository repository;

    @Override
    public String get(Long id) {
        return repository.get(id);
    }
}
