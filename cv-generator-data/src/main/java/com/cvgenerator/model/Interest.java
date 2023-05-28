package com.cvgenerator.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "interest")
public class Interest extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Builder
    public Interest(Long id, User user, String name) {
        super(id);
        this.user = user;
        this.name = name;
    }
}
