package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.CandidateInfo;
import org.mapstruct.Mapper;

@Mapper(uses = {EducationMapper.class, EmploymentMapper.class, EmploymentOfferMapper.class, PassportDetailsMapper.class},
componentModel = "spring")
public interface CandidateInfoMapper {
//    @Mapping(source = "passportDetails", target = "candidateInfo.passportDetails")
    CandidateInfo toEntity(CandidateInfoDto dto);

    CandidateInfoDto toDto(CandidateInfo entity);
}
