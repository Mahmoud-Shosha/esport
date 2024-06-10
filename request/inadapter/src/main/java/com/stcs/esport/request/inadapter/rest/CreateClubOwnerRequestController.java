package com.stcs.esport.request.inadapter.rest;

import com.stcs.esport.request.inport.CreateClubOwnerRequestCommand;
import com.stcs.esport.request.inport.CreateClubOwnerRequestRes;
import com.stcs.esport.request.inport.CreateClubOwnerRequestUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/requests")
@RequiredArgsConstructor
public class CreateClubOwnerRequestController {

    private final CreateClubOwnerRequestUseCase createClubOwnerRequestUseCase;

    @PostMapping
    public ResponseEntity<CreateClubOwnerRequestRes> createClubOwnerRequest(@RequestBody CreateClubOwnerRequestCommand command) {
        return ResponseEntity.ok(createClubOwnerRequestUseCase.createClubOwnerRequest(command));
    }

}
