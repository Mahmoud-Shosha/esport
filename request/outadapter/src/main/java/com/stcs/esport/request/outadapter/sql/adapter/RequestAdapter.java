package com.stcs.esport.request.outadapter.sql.adapter;

import com.stcs.esport.request.model.Request;
import com.stcs.esport.request.model.status.RequestStatus;
import com.stcs.esport.request.outadapter.sql.entity.RequestEntity;
import com.stcs.esport.request.outadapter.sql.entity.RequestStatusEntityCode;
import com.stcs.esport.request.outadapter.sql.repo.RequestRepo;
import com.stcs.esport.request.outadapter.sql.repo.RequestStatusRepo;
import com.stcs.esport.request.outport.CreateRequestPort;
import com.stcs.esport.request.outport.GetCountryPort;
import com.stcs.esport.request.outport.GetRequestStatusPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestAdapter implements CreateRequestPort {

    private final RequestRepo requestRepo;
    private final RequestStatusRepo requestStatusRepo;
    private final GetCountryPort getCountryPort;
    private final GetRequestStatusPort getRequestStatusPort;

    @Override
    public Request createRequest(Request request) {
        RequestEntity requestEntity = extracted(request);
        requestRepo.save(requestEntity);
        return buildRequest(requestEntity);
    }

    private RequestEntity extracted(Request request) {
        return RequestEntity.builder()
                .id(request.getId())
                .ownerName(request.getOwnerName())
                .clubName(request.getClubName())
                .clubNameAr(request.getClubNameAr())
                .clubIBAN(request.getClubIBAN())
                .email(request.getEmail())
                .countryCode(request.getCountryCode())
                .mobileNumber(request.getMobileNumber())
                .nationalityId(request.getNationality().getId())
                .statusId(requestStatusRepo.findByCode(RequestStatusEntityCode.NEW).getId())
                .nationalId(request.getNationalId())
                .build();
    }

    private Request buildRequest(RequestEntity requestEntity) {
        return Request.builder()
                .id(requestEntity.getId())
                .ownerName(requestEntity.getOwnerName())
                .clubName(requestEntity.getClubName())
                .clubNameAr(requestEntity.getClubNameAr())
                .clubIBAN(requestEntity.getClubIBAN())
                .email(requestEntity.getEmail())
                .countryCode(requestEntity.getCountryCode())
                .mobileNumber(requestEntity.getMobileNumber())
                .nationality(getCountryPort.getCountryById(requestEntity.getNationalityId()))
                .status(getRequestStatusPort.getRequestStatusById(requestEntity.getStatusId()))
                .nationalId(requestEntity.getNationalId())
                .build();
    }


}
