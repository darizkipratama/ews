package com.sipdasrh.ews.service.mapper;

import com.sipdasrh.ews.domain.Spas;
import com.sipdasrh.ews.domain.SpasArrInstall;
import com.sipdasrh.ews.service.dto.SpasArrInstallDTO;
import com.sipdasrh.ews.service.dto.SpasDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SpasArrInstall} and its DTO {@link SpasArrInstallDTO}.
 */
@Mapper(componentModel = "spring")
public interface SpasArrInstallMapper extends EntityMapper<SpasArrInstallDTO, SpasArrInstall> {
    @Mapping(target = "spas", source = "spas", qualifiedByName = "spasId")
    SpasArrInstallDTO toDto(SpasArrInstall s);

    @Named("spasId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SpasDTO toDtoSpasId(Spas spas);
}
