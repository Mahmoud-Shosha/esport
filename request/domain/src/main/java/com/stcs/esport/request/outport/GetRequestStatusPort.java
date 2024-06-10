package com.stcs.esport.request.outport;

import com.stcs.esport.request.model.status.RequestStatus;
import com.stcs.esport.request.model.status.RequestStatusCode;

import java.util.UUID;

public interface GetRequestStatusPort {

    RequestStatus getRequestStatusByCode(RequestStatusCode code);
    RequestStatus getRequestStatusById(UUID id);

}
