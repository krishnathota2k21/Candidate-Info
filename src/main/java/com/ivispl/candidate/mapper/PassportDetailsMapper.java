package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.PassportDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportDetailsMapper {
    PassportDetails toEntity(CandidateInfoDto.PassportDetailsDto dto);
    CandidateInfoDto.PassportDetailsDto toDto(PassportDetails entity);
}
