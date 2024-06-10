package com.stcs.esport.request.outadapter.sql.repo;

import com.stcs.esport.request.outadapter.sql.entity.RequestStatusEntityCode;
import com.stcs.esport.request.outadapter.sql.entity.RequestStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestStatusRepo extends JpaRepository<RequestStatusEntity, UUID> {
    RequestStatusEntity findByCode(RequestStatusEntityCode code);

}