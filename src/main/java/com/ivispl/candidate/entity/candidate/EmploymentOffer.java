package com.ivispl.candidate.entity.candidate;

import com.ivispl.candidate.constants.OfferStatus;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "employment_offer")
@Data
public class EmploymentOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employer_name")
    private String employerName;

    @Column(name = "offer_status")
    private OfferStatus offerStatus;

    @Column(name = "offer_issued")
    private LocalDate offerIssued;

    @Column(name = "joining_date_inoffer")
    private LocalDate joiningDateInOffer;

    @Column(name = "place_of_reporting")
    private String placeOfReporting;

    @Column(name = "confirmed_joining_date")
    private LocalDate confirmedJoiningDate;

    @Column(name = "offered_ctc")
    private BigInteger offeredCtc;

    @Column(name = "variable_pay_included")
    private boolean variablePayIncluded;

    @Column(name = "variable_ctc")
    private BigInteger variableCtc;

    @Column(name = "reason")
    private String reasonForRejection;

    @ManyToOne
    private CandidateInfo candidateInfo;
}
