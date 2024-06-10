package com.stcs.esport.request.outadapter.sql.repo;

import com.stcs.esport.request.outadapter.sql.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestRepo extends JpaRepository<RequestEntity, UUID> {
}