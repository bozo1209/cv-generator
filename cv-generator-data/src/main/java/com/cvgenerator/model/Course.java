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
@Table(name = "course")
public class Course extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "organizer_unit")
    private String organizerUnit;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "start_date")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "end_date")
    private LocalDate endDate;

    @Builder
    public Course(Long id, User user, String name, String organizerUnit, LocalDate startDate, LocalDate endDate) {
        super(id);
        this.user = user;
        this.name = name;
        this.organizerUnit = organizerUnit;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
