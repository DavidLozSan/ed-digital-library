package com.iesam.library.features.digitalCollection.domain;

public class DigitalCollection {
    public final String code;
    public final String digitalResourceType;
    public final String name;

    public DigitalCollection(String code, String digitalResourceType, String name) {
        this.code = code;
        this.digitalResourceType = digitalResourceType;
        this.name = name;
    }

    @Override
    public String toString() {
        return "DigitalCollection{" +
                "code='" + code + '\'' +
                ", digitalResourceType='" + digitalResourceType + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCode() {
        return code;
    }

    public String getDigitalResourceType() {
        return digitalResourceType;
    }

    public String getName() {
        return name;
    }
}
