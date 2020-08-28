package com.techcret.tradcret.controller;

import com.techcret.tradcret.repository.AdminRepository;
import com.techcret.tradcret.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping(value = "/", params = "roleName")
    public ResponseEntity<?> list(@RequestParam("roleName") String roleName) {
        long count = roleName.equals("admin") ? adminRepository.count() : personRepository.count();
        return ResponseEntity.ok("Total User of Type " + roleName + " are " + count);
    }


}
