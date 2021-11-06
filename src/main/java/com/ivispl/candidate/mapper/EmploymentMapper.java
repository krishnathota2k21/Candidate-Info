package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.Employment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmploymentMapper {

    EmploymentMapper eMapper = Mappers.getMapper(EmploymentMapper.class);

    Employment toEntity(CandidateInfoDto.EmploymentDto dto);
    CandidateInfoDto.EmploymentDto toDto(Employment entity);
}
