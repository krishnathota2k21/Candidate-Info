package com.ivispl.candidate.dto;

import com.ivispl.candidate.constants.OfferStatus;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CandidateInfoDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private BigInteger mobileNumber;
    private List<EducationDto> educationDetails;
    private List<EmploymentDto> employmentHistory;
    private String panNumber;
    private BigInteger aadhaarNumber;
    private PassportDetailsDto passportDetails;
    private List<EmploymentOfferDto> employmentOffers;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String modifiedBy;

    @Data
    public static class EducationDto {
        private Long id;
        private String course;
        private LocalDate courseStarted;
        private LocalDate courseCompleted;
        private String institutionName;
        private String universityName;
    }

    @Data
    public static class EmploymentDto {
        private Long id;
        private boolean currentCompany;
        private LocalDate startDate;
        private LocalDate endDate;
        private String employerName;
        private String location;
        private String designation;
        private BigInteger offeredCtc;
        private boolean variablePayIncluded;
    }

    @Data
    public static class PassportDetailsDto {
        private Long id;
        private LocalDate issuedDate;
        private LocalDate expiryDate;
        private String issuedLocation;
        private String passportNumber;
        private boolean holdingVisa;
        private String visaIssuedCountry;
        private LocalDate visaExpiryDate;
    }

    @Data
    public static class EmploymentOfferDto {
        private Long id;
        private String employerName;
        private OfferStatus offerStatus;
        private LocalDate offerIssued;
        private LocalDate joiningDateInOffer;
        private String placeOfReporting;
        private LocalDate confirmedJoiningDate;
        private BigInteger offeredCtc;
        private boolean variablePayIncluded;
        private BigInteger variableCtc;
        private String reasonForRejection;
    }

}
