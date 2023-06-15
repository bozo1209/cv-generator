package com.cvgenerator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class Resume extends BaseEntity {

    private User user;
    private PersonalInfo personalInfo;
    private ProfessionalTitle professionalTitle;
    private ProfessionalSummary professionalSummary;
    private Set<Experience> experienceSet = new HashSet<>();
    private Set<Education> educationSet = new HashSet<>();
    private Set<Skill> skillSet = new HashSet<>();
    private Set<Software> softwareSet = new HashSet<>();
    private Set<Language> languageSet = new HashSet<>();
    private Set<Course> courseSet = new HashSet<>();
    private Set<Interest> interestSet = new HashSet<>();
    private Clause clause;

    @Builder
    public Resume(
            Long id,
            User user,
            PersonalInfo personalInfo,
            ProfessionalTitle professionalTitle,
            ProfessionalSummary professionalSummary,
            Set<Experience> experienceSet,
            Set<Education> educationSet,
            Set<Skill> skillSet,
            Set<Software> softwareSet,
            Set<Language> languageSet,
            Set<Course> courseSet,
            Set<Interest> interestSet,
            Clause clause) {
        super(id);
        this.user = user;
        this.personalInfo = personalInfo;
        this.professionalTitle = professionalTitle;
        this.professionalSummary = professionalSummary;
        this.experienceSet = Optional.ofNullable(experienceSet).orElseGet(this::getExperienceSet);
        this.educationSet = Optional.ofNullable(educationSet).orElseGet(this::getEducationSet);
        this.skillSet = Optional.ofNullable(skillSet).orElseGet(this::getSkillSet);
        this.softwareSet = Optional.ofNullable(softwareSet).orElseGet(this::getSoftwareSet);
        this.languageSet = Optional.ofNullable(languageSet).orElseGet(this::getLanguageSet);
        this.courseSet = Optional.ofNullable(courseSet).orElseGet(this::getCourseSet);
        this.interestSet = Optional.ofNullable(interestSet).orElseGet(this::getInterestSet);
        this.clause = clause;
    }
}
