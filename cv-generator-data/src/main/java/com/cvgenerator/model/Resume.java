package com.cvgenerator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resume")
public class Resume extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "personal_info_id")
    private PersonalInfo personalInfo;

    @ManyToOne
    @JoinColumn(name = "professional_title_id")
    private ProfessionalTitle professionalTitle;

    @ManyToOne
    @JoinColumn(name = "professional_summary_id")
    private ProfessionalSummary professionalSummary;

    @ManyToMany
    @JoinTable(name = "resumes_experiences",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id"))
    private Set<Experience> experienceSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "resumes_educations",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "education_id"))
    private Set<Education> educationSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "resumes_skills",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skillSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "resumes_software",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "software_id"))
    private Set<Software> softwareSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "resumes_languages",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private Set<Language> languageSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "resumes_courses",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courseSet = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "resumes_interests",
            joinColumns = @JoinColumn(name = "resume_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id"))
    private Set<Interest> interestSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "clause_id")
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
