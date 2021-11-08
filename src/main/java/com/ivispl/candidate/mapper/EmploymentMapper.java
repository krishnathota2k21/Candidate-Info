package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.Employment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmploymentMapper {

    Employment toEntity(CandidateInfoDto.EmploymentDto dto);
    CandidateInfoDto.EmploymentDto toDto(Employment entity);
}
