package com.stcs.esport.request.model.status;

import lombok.*;

import java.util.UUID;

@Data
public abstract class RequestStatus {

    private UUID id;
    private String name;
    private String nameAr;
    private final RequestStatusCode code;

    RequestStatus(RequestStatusCode code) {
        this.code = code;
    }

    public static RequestStatus fromCode(RequestStatusCode code) {
        return switch (code) {
            case NEW -> NewStatus.getInstance();
            case APPROVED -> ApprovedStatus.getInstance();
            default -> null;
        };

        // TODO complete remaining enums
    }


}
