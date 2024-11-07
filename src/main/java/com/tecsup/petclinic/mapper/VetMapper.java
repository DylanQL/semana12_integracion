package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.domain.VetTO;
import com.tecsup.petclinic.entities.Vet;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 *
 * @author
 *
 */
@Mapper(componentModel = "spring")
public interface VetMapper {

    VetMapper INSTANCE = Mappers.getMapper(VetMapper.class);

    Vet toVet(VetTO vetTO);

    VetTO toVetTO(Vet vet);

    List<VetTO> toVetTOList(List<Vet> vetList);

    List<Vet> toVetList(List<VetTO> vetTOList);
}
