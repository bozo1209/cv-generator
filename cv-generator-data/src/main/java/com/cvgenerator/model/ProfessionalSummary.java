package com.cvgenerator.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "professional_summary")
public class ProfessionalSummary extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "summary")
    private String summary;

    @Builder
    public ProfessionalSummary(Long id, User user, String summary) {
        super(id);
        this.user = user;
        this.summary = summary;
    }
}
