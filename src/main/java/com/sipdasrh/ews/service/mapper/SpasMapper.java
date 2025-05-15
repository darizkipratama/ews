package com.sipdasrh.ews.service.mapper;

import com.sipdasrh.ews.domain.Spas;
import com.sipdasrh.ews.service.dto.SpasDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Spas} and its DTO {@link SpasDTO}.
 */
@Mapper(componentModel = "spring")
public interface SpasMapper extends EntityMapper<SpasDTO, Spas> {}
