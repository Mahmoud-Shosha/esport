package com.stcs.esport.request.outadapter.sql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "request_status")
public class RequestStatusEntity {

    @Id
    @Column(nullable = false, unique = true)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String nameAr;
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RequestStatusEntityCode code;

}
