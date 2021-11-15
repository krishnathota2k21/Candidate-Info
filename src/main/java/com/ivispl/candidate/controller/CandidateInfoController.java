package com.ivispl.candidate.controller;

import com.ivispl.candidate.dto.CandidateInfoDto;
import com.ivispl.candidate.error.CandidateNotFoundException;
import com.ivispl.candidate.service.CandidateInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

import static com.ivispl.candidate.constants.Constants.INDEX;

/**
 * this class provides or stores the candidate information.
 */
@Controller
@RequestMapping("/candidate")
@Slf4j
public class CandidateInfoController {
    private final CandidateInfoService candidateInfoService;

    public CandidateInfoController(CandidateInfoService candidateInfoService) {
        this.candidateInfoService = candidateInfoService;
    }

    /**
     * this method persists the candidate information.
     * @param candidateInfoDto candidate info
     * @param model to pass the messages
     * @return view name
     */
    @PostMapping
    public String addCandidateInfo(@RequestBody CandidateInfoDto candidateInfoDto, Model model) {
        boolean success = candidateInfoService.addCandidateInfo(candidateInfoDto);
        if (success) {
            model.addAttribute("successMessage", "Candidate information successfully added.");
        }
        return INDEX;

    }

    /**
     * this method returns the candidate info searched based the pan number provided.
     * @param panNumber pan number of the candidate.
     * @param model model
     * @return candidate info to view.
     */
    @GetMapping
    public String viewCandidateInfo(@RequestParam("panNumber") String panNumber, Model model) {
        CandidateInfoDto candidateInfoDto = candidateInfoService.findDetails(panNumber);
        if (Objects.nonNull(candidateInfoDto)) {
            log.info("candidate info found:: {}",candidateInfoDto);
            model.addAttribute("successMessage", "Candidate information successfully added.");
            model.addAttribute("candidateInfo", candidateInfoDto);
        } else {
            log.info("candidate info not found:: {}",panNumber);
            model.addAttribute("errorMessage", "candidate info not found of "+panNumber);
        }
        return INDEX;
    }

    @PutMapping("/{id}")
    public String updateCandidateInfo(@PathVariable("id") Long candidateInfoId,
                                       @RequestBody CandidateInfoDto candidateInfoDto,
                                       Model model) {
        CandidateInfoDto updatedCandidateInfoDto = candidateInfoService.updateCandidateInfo(candidateInfoId, candidateInfoDto, model);
        model.addAttribute("candidateInfo", updatedCandidateInfoDto);
        return INDEX;
    }

    @DeleteMapping("/{id}")
    public String deleteCandidateInfo(@PathVariable("id") Long id, Model model){
        candidateInfoService.deleteCandidateInfo(id);
        return "";
    }
}
