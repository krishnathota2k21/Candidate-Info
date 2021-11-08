package com.ivispl.candidate.service;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.CandidateInfo;
import com.ivispl.candidate.error.CandidateNotFoundException;
import com.ivispl.candidate.mapper.CandidateInfoMapper;
import com.ivispl.candidate.reposiroty.CandidateInfoRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Objects;
import java.util.Optional;

@Service
public class CandidateInfoService {

    private final CandidateInfoRepository candidateInfoRepository;
    private final CandidateInfoMapper candidateInfoMapper;

    public CandidateInfoService(CandidateInfoRepository candidateInfoRepository, CandidateInfoMapper candidateInfoMapper) {
        this.candidateInfoRepository = candidateInfoRepository;
        this.candidateInfoMapper = candidateInfoMapper;
    }


    public CandidateInfoDto findDetails(String panNumber) throws CandidateNotFoundException {
        CandidateInfo entity = candidateInfoRepository.findByPanNumber(panNumber);
        if (Objects.isNull(entity)){
            throw new CandidateNotFoundException();
        }
        return candidateInfoMapper.toDto(entity);
    }

    public boolean addCandidateInfo(CandidateInfoDto candidateInfoDto) {
        CandidateInfo entity = candidateInfoMapper.toEntity(candidateInfoDto);
        candidateInfoRepository.save(entity);
        return entity.getId() != null;
    }

    public CandidateInfoDto updateCandidateInfo(Long candidateInfoId, CandidateInfoDto candidateInfoDto, Model model) {
        candidateInfoRepository.findById(candidateInfoId).ifPresent(candidateInfo -> {
            CandidateInfo updatedEntity = candidateInfoMapper.toEntity(candidateInfoDto);
            candidateInfoRepository.save(updatedEntity);
            model.addAttribute("successMessage", "candidate info has been updated.");
        });
        return candidateInfoDto;
    }

    public void deleteCandidateInfo(Long id) {
        candidateInfoRepository.findById(id).ifPresent(candidateInfo -> {

        });
    }
}
