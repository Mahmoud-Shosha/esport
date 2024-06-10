package com.stcs.esport.user.outadapter.entity;

import com.stcs.esport.country.outadapter.sql.entity.CountryEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
public class UserEntity {

    @Id
    @Column(nullable = false, unique = true)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private String countryCode;
    @Column(nullable = false)
    private String mobileNumber;
    @Column(nullable = false)
    private String email;
    @ManyToOne
    @JoinColumn(name = "nationality_id", nullable = false)
    private CountryEntity nationality;


}
