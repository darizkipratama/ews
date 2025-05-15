package com.sipdasrh.ews.service.mapper;

import static com.sipdasrh.ews.domain.SpasAsserts.*;
import static com.sipdasrh.ews.domain.SpasTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpasMapperTest {

    private SpasMapper spasMapper;

    @BeforeEach
    void setUp() {
        spasMapper = new SpasMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getSpasSample1();
        var actual = spasMapper.toEntity(spasMapper.toDto(expected));
        assertSpasAllPropertiesEquals(expected, actual);
    }
}
