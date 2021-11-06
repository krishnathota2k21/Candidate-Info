package com.ivispl.candidate.mapper;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.PassportDetails;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PassportDetailsMapper {
    PassportDetailsMapper pdMapper = Mappers.getMapper(PassportDetailsMapper.class);

    PassportDetails toEntity(CandidateInfoDto.PassportDetailsDto dto);
    CandidateInfoDto.PassportDetailsDto toDto(PassportDetails entity);
}
