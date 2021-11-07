package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.CandidateInfo;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(uses = {EducationMapper.class, EmploymentMapper.class, EmploymentOfferMapper.class, PassportDetailsMapper.class},
componentModel = "spring")
public interface CandidateInfoMapper {

    @AfterMapping
    default void afterCandidateInfoMapping(@MappingTarget CandidateInfo candidateInfo){
        candidateInfo.getEducationDetails().forEach(education -> education.setCandidateInfo(candidateInfo));
        candidateInfo.getEmploymentHistory().forEach(employment -> employment.setCandidateInfo(candidateInfo));
        candidateInfo.getEmploymentOffers().forEach(employmentOffer -> employmentOffer.setCandidateInfo(candidateInfo));
        candidateInfo.getPassportDetails().setCandidateInfo(candidateInfo);
    }
    CandidateInfo toEntity(CandidateInfoDto dto);

    CandidateInfoDto toDto(CandidateInfo entity);
}
