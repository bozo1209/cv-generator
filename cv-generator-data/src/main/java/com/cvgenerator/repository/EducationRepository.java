package com.cvgenerator.repository;

import com.cvgenerator.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
