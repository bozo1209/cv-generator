package com.cvgenerator.service.map;

import com.cvgenerator.model.Resume;
import com.cvgenerator.service.ResumeService;

import java.util.Optional;
import java.util.Set;

public class ResumeMapService extends AbstractMapService<Resume, Long> implements ResumeService {

    private final ClauseMapService clauseMapService;
    private final CourseMapService courseMapService;
    private final EducationMapService educationMapService;
    private final ExperienceMapService experienceMapService;
    private final InterestMapService interestMapService;
    private final LanguageMapService languageMapService;
    private final PersonalInfoMapService personalInfoMapService;
    private final ProfessionalSummaryMapService professionalSummaryMapService;
    private final ProfessionalTitleMapService professionalTitleMapService;
    private final SkillMapService skillMapService;
    private final SoftwareMapService softwareMapService;

    public ResumeMapService(
            ClauseMapService clauseMapService,
            CourseMapService courseMapService,
            EducationMapService educationMapService,
            ExperienceMapService experienceMapService,
            InterestMapService interestMapService,
            LanguageMapService languageMapService,
            PersonalInfoMapService personalInfoMapService,
            ProfessionalSummaryMapService professionalSummaryMapService,
            ProfessionalTitleMapService professionalTitleMapService,
            SkillMapService skillMapService,
            SoftwareMapService softwareMapService) {
        this.clauseMapService = clauseMapService;
        this.courseMapService = courseMapService;
        this.educationMapService = educationMapService;
        this.experienceMapService = experienceMapService;
        this.interestMapService = interestMapService;
        this.languageMapService = languageMapService;
        this.personalInfoMapService = personalInfoMapService;
        this.professionalSummaryMapService = professionalSummaryMapService;
        this.professionalTitleMapService = professionalTitleMapService;
        this.skillMapService = skillMapService;
        this.softwareMapService = softwareMapService;
    }

    @Override
    public Set<Resume> findAll() {
        return super.findAll();
    }

    @Override
    public Resume findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Resume save(Resume object) {
        Optional.ofNullable(object).ifPresentOrElse(resume -> {
            saveClause(resume);
            saveCourses(resume);
            saveEducations(resume);
            saveExperiences(resume);
            saveInterests(resume);
            saveLanguages(resume);
            savePersonalInfo(resume);
            saveProfessionalSummary(resume);
            saveProfessionalTitle(resume);
            saveSkills(resume);
            saveSoftware(resume);
        }, () -> {
            throw new RuntimeException("object cannot be null");
        });
        return super.save(object);
    }

    @Override
    public void delete(Resume object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    private void saveClause(Resume resume){
        Optional.ofNullable(resume.getClause()).ifPresent(clauseMapService::save);
    }

    private void saveCourses(Resume resume){
        resume.getCourseSet().forEach(courseMapService::save);
    }

    private void saveEducations(Resume resume){
        resume.getEducationSet().forEach(educationMapService::save);
    }

    private void saveExperiences(Resume resume){
        resume.getExperienceSet().forEach(experienceMapService::save);
    }

    private void saveInterests(Resume resume){
        resume.getInterestSet().forEach(interestMapService::save);
    }

    private void saveLanguages(Resume resume){
        resume.getLanguageSet().forEach(languageMapService::save);
    }

    private void savePersonalInfo(Resume resume){
        Optional.ofNullable(resume.getPersonalInfo()).ifPresent(personalInfoMapService::save);
    }

    private void saveProfessionalSummary(Resume resume){
        Optional.ofNullable(resume.getProfessionalSummary()).ifPresent(professionalSummaryMapService::save);
    }

    private void saveProfessionalTitle(Resume resume){
        Optional.ofNullable(resume.getProfessionalTitle()).ifPresent(professionalTitleMapService::save);
    }

    private void saveSkills(Resume resume){
        resume.getSkillSet().forEach(skillMapService::save);
    }

    private void saveSoftware(Resume resume){
        resume.getSoftwareSet().forEach(softwareMapService::save);
    }
}
