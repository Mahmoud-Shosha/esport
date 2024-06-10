package com.stcs.esport.request.model.status;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class NewStatus extends RequestStatus {

    private static final NewStatus instance = new NewStatus();

    private NewStatus() {
        super(RequestStatusCode.NEW);
    }

    public static NewStatus getInstance() {
        return instance;
    }

}
