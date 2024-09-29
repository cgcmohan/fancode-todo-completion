package com.fancode.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fancode.model.UserValidationResponse;
import com.fancode.service.UserValidationBL;

@RestController
@RequestMapping("/fancode")
public class FancodeController {
	@Autowired
    private UserValidationBL userValidationBL;

    @GetMapping("/validate")
    public ResponseEntity<List<UserValidationResponse>> validateUsers() {
    	 List<UserValidationResponse> validationResults = userValidationBL.validateFancodeUsers();
         if (validationResults.isEmpty()) {
             throw new NoSuchElementException("No users found in FanCode city with more than 50% todo completion.");
         }
         return ResponseEntity.ok(validationResults);
    }
    
}
