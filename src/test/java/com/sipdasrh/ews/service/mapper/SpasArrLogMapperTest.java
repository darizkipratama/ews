package com.sipdasrh.ews.service.mapper;

import static com.sipdasrh.ews.domain.SpasArrLogAsserts.*;
import static com.sipdasrh.ews.domain.SpasArrLogTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpasArrLogMapperTest {

    private SpasArrLogMapper spasArrLogMapper;

    @BeforeEach
    void setUp() {
        spasArrLogMapper = new SpasArrLogMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getSpasArrLogSample1();
        var actual = spasArrLogMapper.toEntity(spasArrLogMapper.toDto(expected));
        assertSpasArrLogAllPropertiesEquals(expected, actual);
    }
}
