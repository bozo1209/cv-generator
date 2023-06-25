package com.cvgenerator.repository;

import com.cvgenerator.model.Software;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoftwareRepository extends JpaRepository<Software, Long> {
}
