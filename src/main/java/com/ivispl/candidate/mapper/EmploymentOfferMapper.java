package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.EmploymentOffer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmploymentOfferMapper {

    EmploymentOfferMapper eoMapper = Mappers.getMapper(EmploymentOfferMapper.class);

    EmploymentOffer toEntity(CandidateInfoDto.EmploymentOfferDto dto);
    CandidateInfoDto.EmploymentOfferDto toDto(EmploymentOffer entity);
}
