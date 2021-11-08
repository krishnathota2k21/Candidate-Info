package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.Education;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EducationMapper {

    Education toEntity(CandidateInfoDto.EducationDto dto);
    CandidateInfoDto.EducationDto toDto(Education entity);
}
