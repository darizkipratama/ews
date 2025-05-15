package com.sipdasrh.ews.service.mapper;

import static com.sipdasrh.ews.domain.SpasArrInstallAsserts.*;
import static com.sipdasrh.ews.domain.SpasArrInstallTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpasArrInstallMapperTest {

    private SpasArrInstallMapper spasArrInstallMapper;

    @BeforeEach
    void setUp() {
        spasArrInstallMapper = new SpasArrInstallMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getSpasArrInstallSample1();
        var actual = spasArrInstallMapper.toEntity(spasArrInstallMapper.toDto(expected));
        assertSpasArrInstallAllPropertiesEquals(expected, actual);
    }
}
