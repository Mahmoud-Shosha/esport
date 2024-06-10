package com.stcs.esport.request.outadapter.sql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request")
public class RequestEntity {
    @Id
    @Column(nullable = false, unique = true)
    private UUID id;
    @Column(nullable = false)
    private String ownerName;
    @Column(nullable = false)
    private String countryCode;
    @Column(nullable = false)
    private String mobileNumber;
    @Column(nullable = false)
    private String nationalId;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String clubName;
    @Column(nullable = false)
    private String clubNameAr;
    @Column(name = "club_iban", nullable = false)
    private String clubIBAN;
    @Column(nullable = false)
    private UUID nationalityId;
    @Column(nullable = false)
    private UUID statusId;

}