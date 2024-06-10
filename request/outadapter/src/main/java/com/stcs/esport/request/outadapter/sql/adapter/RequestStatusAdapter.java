package com.stcs.esport.request.outadapter.sql.adapter;

import com.stcs.esport.request.model.status.NewStatus;
import com.stcs.esport.request.model.status.RequestStatus;
import com.stcs.esport.request.model.status.RequestStatusCode;
import com.stcs.esport.request.outadapter.sql.entity.RequestStatusEntity;
import com.stcs.esport.request.outadapter.sql.entity.RequestStatusEntityCode;
import com.stcs.esport.request.outadapter.sql.repo.RequestStatusRepo;
import com.stcs.esport.request.outport.GetRequestStatusPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RequestStatusAdapter implements GetRequestStatusPort {

    private final RequestStatusRepo requestStatusRepo;
    private final ModelMapper mapper;

    @Override
    public RequestStatus getRequestStatusByCode(RequestStatusCode code) {
        RequestStatusEntity requestStatusEntity = requestStatusRepo
                .findByCode(RequestStatusEntityCode.valueOf(code.name()));
        return buildRequestStatus(requestStatusEntity);
    }

    @Override
    public RequestStatus getRequestStatusById(UUID id) {
        RequestStatusEntity requestStatusEntity = requestStatusRepo
                .findById(id).get();
        return buildRequestStatus(requestStatusEntity);
    }

    private RequestStatus buildRequestStatus(RequestStatusEntity entity) {
        return mapper.map(entity, NewStatus.class);
    }

}