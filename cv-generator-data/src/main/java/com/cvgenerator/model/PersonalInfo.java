package com.cvgenerator.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personal_info")
public class PersonalInfo extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToMany
    @JoinColumn(name = "personal_info_id", referencedColumnName = "id")
    private Set<ProfessionalTitle> titles = new HashSet<>();

    @Builder
    public PersonalInfo(Long id, User user, String firstName, String lastName, String phoneNumber, String email, Set<ProfessionalTitle> titles) {
        super(id);
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.titles = Optional.ofNullable(titles).orElseGet(this::getTitles);
    }
}
