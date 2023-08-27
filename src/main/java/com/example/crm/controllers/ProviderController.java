package com.example.crm.controllers;

import com.example.crm.entities.Provider;
import com.example.crm.requests.ProviderRequest;
import com.example.crm.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/secured")
public class ProviderController {
    @Autowired
    ProviderService providerService;

    @GetMapping("/providers")
    public ResponseEntity<?> getProviders() {
         return ResponseEntity.status(HttpStatus.OK).body(providerService.getAllProviders());
    }

    @PostMapping("/providers")
    public ResponseEntity<?> addProvider(@RequestBody ProviderRequest providerRequest) {
        if (providerService.existsProviderByName(providerRequest.getName()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Provider '%s' has been already existed", providerRequest.getName()));

        providerService.addProvider(providerRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }

    @DeleteMapping("/providers/{name}")
    public ResponseEntity<?> deleteProvider(@PathVariable("name") String name) {
        if (providerService.existsProviderByName(name)) {
            providerService.deleteProvider(name);
            return ResponseEntity.status(HttpStatus.OK).body("Success");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(String.format("Provider '%s' hasn't found", name));
    }
}
