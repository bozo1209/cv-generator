package com.cvgenerator.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "language")
public class Language extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private String level;

    @Builder
    public Language(Long id, User user, String name, String level) {
        super(id);
        this.user = user;
        this.name = name;
        this.level = level;
    }
}
