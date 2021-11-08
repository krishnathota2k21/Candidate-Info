package com.ivispl.candidate.entity.candidate;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "employment")
@Data
public class Employment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "current_company")
    private boolean currentCompany;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "employer_name")
    private String employerName;

    @Column(name = "location")
    private String location;

    @Column(name = "designation")
    private String designation;

    @Column(name = "offered_ctc")
    private BigInteger offeredCtc;

    @Column(name = "variable_pay_included")
    private boolean variablePayIncluded;

    @ManyToOne
    private CandidateInfo candidateInfo;

}
