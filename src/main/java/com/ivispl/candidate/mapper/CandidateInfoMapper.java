package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.CandidateInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {EducationMapper.class, EmploymentMapper.class, EmploymentOfferMapper.class, PassportDetailsMapper.class})
public interface CandidateInfoMapper {

    CandidateInfoMapper ciMapper = Mappers.getMapper(CandidateInfoMapper.class);


    CandidateInfo toEntity(CandidateInfoDto dto);
    CandidateInfoDto toDto(CandidateInfo entity);
}
