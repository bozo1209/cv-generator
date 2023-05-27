package com.cvgenerator.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "software")
public class Software extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private String level;

    @Builder
    public Software(Long id, User user, String name, String level) {
        super(id);
        this.user = user;
        this.name = name;
        this.level = level;
    }
}
