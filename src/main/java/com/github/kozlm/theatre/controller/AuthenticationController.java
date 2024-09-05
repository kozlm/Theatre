package com.github.kozlm.theatre.controller;

import com.github.kozlm.theatre.model.client.ClientDto;
import com.github.kozlm.theatre.security.dto.AuthenticationRequest;
import com.github.kozlm.theatre.service.AuthenticationService;
import com.github.kozlm.theatre.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final ClientService clientService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody @Valid ClientDto dto) {
        clientService.addClient(dto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> authenticate(@RequestBody AuthenticationRequest request) {
        Map<String, Object> responseObject = new HashMap<>();
        responseObject.put("token", authenticationService.authenticate(request));
        return responseObject;
    }
}
