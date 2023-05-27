package com.cvgenerator.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "education")
public class Education extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "field_of_study")
    private String fieldOfStudy;

    @Column(name = "academic_degree")
    private String academicDegree;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "currently")
    private Boolean currently;

    @Builder
    public Education(Long id, User user, String schoolName, String fieldOfStudy, String academicDegree, LocalDate startDate, LocalDate endDate, Boolean currently) {
        super(id);
        this.user = user;
        this.schoolName = schoolName;
        this.fieldOfStudy = fieldOfStudy;
        this.academicDegree = academicDegree;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currently = currently;
    }
}
