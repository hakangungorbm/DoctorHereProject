package com.doctorhere.reference.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hakangungorbm
 * @date 4.12.2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/reference")
public class ReferenceApiController {

    @GetMapping("/hello")
    public String helloWorld () {
        return "Uygulama calisiyor";
    }
}
