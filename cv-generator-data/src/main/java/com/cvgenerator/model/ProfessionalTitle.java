package com.cvgenerator.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "professional_title")
public class ProfessionalTitle extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Builder
    public ProfessionalTitle(Long id, User user, String title) {
        super(id);
        this.user = user;
        this.title = title;
    }
}
