package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.EmploymentOffer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmploymentOfferMapper {

    EmploymentOffer toEntity(CandidateInfoDto.EmploymentOfferDto dto);
    CandidateInfoDto.EmploymentOfferDto toDto(EmploymentOffer entity);
}
