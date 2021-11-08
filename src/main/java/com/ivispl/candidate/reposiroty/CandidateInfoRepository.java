package com.ivispl.candidate.reposiroty;

import com.ivispl.candidate.entity.candidate.CandidateInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateInfoRepository extends JpaRepository<CandidateInfo, Long> {
    CandidateInfo findByPanNumber(String panNumber);
}
