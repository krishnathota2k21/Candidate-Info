package com.ivispl.candidate.entity.candidate;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "education")
@Data
public class Education {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "course")
    private String course;

    @Column(name = "course_started")
    private LocalDate courseStarted;

    @Column(name = "course_completed")
    private LocalDate courseCompleted;

    @Column(name = "institution_name")
    private String institutionName;

    @Column(name = "university_name")
    private String universityName;

    @ManyToOne
    private CandidateInfo candidateInfo;
}
