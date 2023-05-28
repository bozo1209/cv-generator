package com.cvgenerator.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clause")
public class Clause extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "clause")
    private String clause;

    @Builder
    public Clause(Long id, User user, String clause) {
        super(id);
        this.user = user;
        this.clause = clause;
    }
}
