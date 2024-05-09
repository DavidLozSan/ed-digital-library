package com.iesam.library.features.digitalCollection.domain;

import java.util.List;

public interface DigitalRepository {
    void save(DigitalCollection digitalCollection);

    DigitalCollection obtain(String digitalResourceCode);

    List<DigitalCollection> obtainDigitalResources();
}
