package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.Education;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EducationMapper {

    EducationMapper eMapper = Mappers.getMapper(EducationMapper.class);

    Education toEntity(CandidateInfoDto.EducationDto dto);
    CandidateInfoDto.EducationDto toDto(Education entity);
}
