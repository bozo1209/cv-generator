package com.cvgenerator.service.map;

import com.cvgenerator.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ResumeMapServiceTest {

    ResumeMapService resumeMapService;
    Resume resume;
    Long resumeId = 1L;

    @BeforeEach
    void setUp() {
        resumeMapService = new ResumeMapService(
                new ClauseMapService(),
                new CourseMapService(),
                new EducationMapService(),
                new ExperienceMapService(),
                new InterestMapService(),
                new LanguageMapService(),
                new PersonalInfoMapService(),
                new ProfessionalSummaryMapService(),
                new ProfessionalTitleMapService(),
                new SkillMapService(),
                new SoftwareMapService()
        );

        resume = Resume.builder().id(resumeId).build();

        resumeMapService.save(resume);
    }

    @Test
    void findAll() {
        Set<Resume> resumes = resumeMapService.findAll();

        assertEquals(1, resumes.size());
    }

    @Test
    void findById() {
        Resume foundResume = resumeMapService.findById(resumeId);

        assertEquals(resumeId, foundResume.getId());
    }

    @Test
    void saveExistId() {
        Long id = 2L;
        Resume savedResume = resumeMapService.save(Resume.builder().id(id).build());

        assertNotNull(savedResume);
        assertEquals(id, savedResume.getId());
    }

    @Test
    void saveNoId() {
        Resume savedResume = resumeMapService.save(Resume.builder().build());

        assertNotNull(savedResume);
        assertNotNull(savedResume.getId());
    }

    @Test
    void saveWithClause(){
        Clause clause = Clause.builder().clause("clause").build();

        Resume savedResume = resumeMapService.save(Resume.builder().clause(clause).build());

        assertNotNull(savedResume.getClause().getId());
    }

    @Test
    void saveWithCourse(){
        Course course = Course.builder().name("course").build();

        Resume savedResume = resumeMapService.save(Resume.builder().courseSet(Set.of(course)).build());

        assertNotNull(savedResume.getCourseSet().stream().toList().get(0).getId());
    }

    @Test
    void saveWithEducation(){
        Education education = Education.builder().schoolName("edu").build();

        Resume savedResume = resumeMapService.save(Resume.builder().educationSet(Set.of(education)).build());

        assertNotNull(savedResume.getEducationSet().stream().toList().get(0).getId());
    }

    @Test
    void saveWithExperience(){
        Experience experience = Experience.builder().companyName("exp").build();

        Resume savedResume = resumeMapService.save(Resume.builder().experienceSet(Set.of(experience)).build());

        assertNotNull(savedResume.getExperienceSet().stream().toList().get(0).getId());
    }

    @Test
    void saveWithInterest(){
        Interest interest = Interest.builder().name("interest").build();

        Resume savedResume = resumeMapService.save(Resume.builder().interestSet(Set.of(interest)).build());

        assertNotNull(savedResume.getInterestSet().stream().toList().get(0).getId());
    }

    @Test
    void saveWithLanguage(){
        Language language = Language.builder().name("lang").build();

        Resume savedResume = resumeMapService.save(Resume.builder().languageSet(Set.of(language)).build());

        assertNotNull(savedResume.getLanguageSet().stream().toList().get(0).getId());
    }

    @Test
    void saveWithPersonalInfo(){
        PersonalInfo personalInfo = PersonalInfo.builder().firstName("name").build();

        Resume savedResume = resumeMapService.save(Resume.builder().personalInfo(personalInfo).build());

        assertNotNull(savedResume.getPersonalInfo().getId());
    }

    @Test
    void saveWithProfessionalSummary(){
        ProfessionalSummary professionalSummary = ProfessionalSummary.builder().summary("summary").build();

        Resume savedResume = resumeMapService.save(Resume.builder().professionalSummary(professionalSummary).build());

        assertNotNull(savedResume.getProfessionalSummary().getId());
    }

    @Test
    void saveWithProfessionalTitle(){
        ProfessionalTitle professionalTitle = ProfessionalTitle.builder().title("title").build();

        Resume savedResume = resumeMapService.save(Resume.builder().professionalTitle(professionalTitle).build());

        assertNotNull(savedResume.getProfessionalTitle().getId());
    }

    @Test
    void saveWithSkill(){
        Skill skill = Skill.builder().name("skill").build();

        Resume savedResume = resumeMapService.save(Resume.builder().skillSet(Set.of(skill)).build());

        assertNotNull(savedResume.getSkillSet().stream().toList().get(0).getId());
    }

    @Test
    void saveWithSoftware(){
        Software software = Software.builder().name("soft").build();

        Resume savedResume = resumeMapService.save(Resume.builder().softwareSet(Set.of(software)).build());

        assertNotNull(savedResume.getSoftwareSet().stream().toList().get(0).getId());
    }

    @Test
    void saveResumeNull(){
        assertThrows(RuntimeException.class, () -> resumeMapService.save(null));
    }

    @Test
    void delete() {
        resumeMapService.delete(resume);

        assertEquals(0, resumeMapService.findAll().size());
    }

    @Test
    void deleteById() {
        resumeMapService.deleteById(resumeId);

        assertEquals(0, resumeMapService.findAll().size());
    }
}