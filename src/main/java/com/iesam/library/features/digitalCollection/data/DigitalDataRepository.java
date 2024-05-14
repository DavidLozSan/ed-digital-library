package com.iesam.library.features.digitalCollection.data;

import com.iesam.library.features.digitalCollection.data.local.DigitalLocalDataSource;
import com.iesam.library.features.digitalCollection.domain.DigitalCollection;
import com.iesam.library.features.digitalCollection.domain.DigitalRepository;

import java.util.List;

public class DigitalDataRepository implements DigitalRepository {
    public final DigitalLocalDataSource digitalLocalDataSource;

    public DigitalDataRepository(DigitalLocalDataSource digitalLocalDataSource) {
        this.digitalLocalDataSource = digitalLocalDataSource;
    }

    @Override
    public void save(DigitalCollection digitalCollection) {
        digitalLocalDataSource.save(digitalCollection);
    }

    @Override
    public DigitalCollection obtain(String digitalResourceCode) {
        return digitalLocalDataSource.findByCode(digitalResourceCode);
    }

    @Override
    public List<DigitalCollection> obtainDigitalResources() {
        return digitalLocalDataSource.findAll();
    }

    @Override
    public void delete(String code) {
        digitalLocalDataSource.delete(code);
    }

    @Override
    public void update(DigitalCollection digitalCollection) {
        digitalLocalDataSource.update(digitalCollection);
    }
}
