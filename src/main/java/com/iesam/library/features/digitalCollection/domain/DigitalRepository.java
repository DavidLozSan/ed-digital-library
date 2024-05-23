package com.iesam.library.features.digitalCollection.domain;

import java.util.List;

public interface DigitalRepository<T extends DigitalCollection> {
    void save(T digitalCollection);

    T obtain(String digitalResourceCode);

    List<T> obtainDigitalResources();

    void delete(String code);

    void update(T digitalCollection);
}
