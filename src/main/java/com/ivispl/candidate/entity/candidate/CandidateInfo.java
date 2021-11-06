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
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_number")
    private BigInteger mobileNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateInfo")
    private List<Education> educationDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateInfo")
    private List<Employment> employmentHistory;

    @Column(name = "pan_number")
    private String panNumber;

    @Column(name = "aadhaar_number")
    private BigInteger aadhaarNumber;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "candidateInfo")
    private PassportDetails passportDetails;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateInfo")
    private List<EmploymentOffer> employmentOffers;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @LastModifiedBy
    @Column(name = "modified_by")
    private String modifiedBy;

}
