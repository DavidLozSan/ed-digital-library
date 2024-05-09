package com.iesam.library.features.digitalCollection.data.local;

import com.iesam.library.features.digitalCollection.domain.DigitalCollection;

import java.util.List;

public interface DigitalLocalDataSource {
    DigitalCollection findByCode(String code);

    void save(DigitalCollection digitalCollection);

    List<DigitalCollection> findAll();
}
