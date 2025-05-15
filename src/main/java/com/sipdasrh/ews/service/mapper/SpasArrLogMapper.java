package com.sipdasrh.ews.service.mapper;

import com.sipdasrh.ews.domain.SpasArrInstall;
import com.sipdasrh.ews.domain.SpasArrLog;
import com.sipdasrh.ews.service.dto.SpasArrInstallDTO;
import com.sipdasrh.ews.service.dto.SpasArrLogDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SpasArrLog} and its DTO {@link SpasArrLogDTO}.
 */
@Mapper(componentModel = "spring")
public interface SpasArrLogMapper extends EntityMapper<SpasArrLogDTO, SpasArrLog> {
    @Mapping(target = "spasArrInstall", source = "spasArrInstall", qualifiedByName = "spasArrInstallId")
    SpasArrLogDTO toDto(SpasArrLog s);

    @Named("spasArrInstallId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    SpasArrInstallDTO toDtoSpasArrInstallId(SpasArrInstall spasArrInstall);
}
