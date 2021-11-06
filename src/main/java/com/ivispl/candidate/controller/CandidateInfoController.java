package com.ivispl.candidate.controller;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.entity.candidate.CandidateInfo;
import com.ivispl.candidate.error.CandidateNotFoundException;
import com.ivispl.candidate.service.CandidateInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("/candidate")
public class CandidateInfoController {
    private final CandidateInfoService candidateInfoService;

    public CandidateInfoController(CandidateInfoService candidateInfoService) {
        this.candidateInfoService = candidateInfoService;
    }

    @PostMapping
    public String addCandidateInfo(@ModelAttribute("candidateInfo") CandidateInfoDto candidateInfoDto, Model model) {
        boolean success = candidateInfoService.addCandidateInfo(candidateInfoDto);
        if (success) {
            model.addAttribute("successMessage", "Candidate information successfully added.");
        }
        return "";

    }

    @GetMapping
    public String viewCandidateInfo(@ModelAttribute("panNumber") String panNumber, Model model) throws CandidateNotFoundException {
        CandidateInfoDto candidateInfoDto = candidateInfoService.findDetails(panNumber);
        if (Objects.nonNull(candidateInfoDto)) {
            model.addAttribute("successMessage", "Candidate information successfully added.");
            model.addAttribute("candidateInfo", candidateInfoDto);
        } else {
            model.addAttribute("errorMessage", "candidate info not found: "+panNumber);
        }
        return "candidate-info";
    }

    @PutMapping("/{id}")
    public String updateCandidateInfo(@PathVariable("id") Long candidateInfoId,
                                       @RequestBody CandidateInfoDto candidateInfoDto,
                                       Model model) {
        CandidateInfoDto updatedCandidateInfoDto = candidateInfoService.updateCandidateInfo(candidateInfoId, candidateInfoDto, model);
        model.addAttribute("candidateInfo", updatedCandidateInfoDto);
        return "";
    }

    @DeleteMapping("/{id}")
    public String deleteCandidateInfo(@PathVariable("id") Long id, Model model){
        candidateInfoService.deleteCandidateInfo(id);
        return "";
    }
}
