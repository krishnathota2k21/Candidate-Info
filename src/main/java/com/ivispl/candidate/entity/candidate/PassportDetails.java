package com.ivispl.candidate.entity.candidate;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passport_details")
@Data
public class PassportDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "issued_date")
    private LocalDate issuedDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "issued_location")
    private String issuedLocation;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "holding_visa")
    private boolean holdingVisa;

    @Column(name = "visa_issued_country")
    private String visaIssuedCountry;

    @Column(name = "visa_expiry_date")
    private LocalDate visaExpiryDate;

    @OneToOne(mappedBy = "passportDetails", fetch = FetchType.LAZY)
    private CandidateInfo candidateInfo;
}
