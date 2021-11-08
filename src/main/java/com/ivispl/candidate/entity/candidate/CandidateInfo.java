package com.ivispl.candidate.entity.candidate;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "candidate_info")
@Data
public class CandidateInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private BigInteger mobileNumber;

    @Column(name = "pan_number")
    private String panNumber;

    @Column(name = "aadhaar_number")
    private BigInteger aadhaarNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateInfo")
    private List<Education> educationDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateInfo")
    private List<Employment> employmentHistory;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "candidateInfo")
    private PassportDetails passportDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateInfo")
    private List<EmploymentOffer> employmentOffers;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @LastModifiedBy
    private String modifiedBy;

}
