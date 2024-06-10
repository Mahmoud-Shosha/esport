package com.stcs.esport.request.model.status;

public class ApprovedStatus extends RequestStatus {

    private static final ApprovedStatus instance = new ApprovedStatus();

    public static ApprovedStatus getInstance() {
        return instance;
    }
    public ApprovedStatus() {
        super(RequestStatusCode.APPROVED);
    }
}

