package com.example.demo.order.core.port_infra.external_system;


import org.springframework.http.ResponseEntity;

import com.example.demo.order.core.application.object.command.SampleDomainCommandApiRequestDTO;

public interface IExternalSampleSystem {

    public ResponseEntity<String> doSomeExternalLogic(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

}