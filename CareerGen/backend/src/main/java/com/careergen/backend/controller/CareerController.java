package com.careergen.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careergen.backend.model.CareerResponse;
import com.careergen.backend.model.SkillRequest;
import com.careergen.backend.service.CareerService;

@RestController
@RequestMapping("/api/careers")
@CrossOrigin(origins = "*")
public class CareerController {

    private final CareerService careerService;

    public CareerController(CareerService careerService) {
        this.careerService = careerService;
    }

    @PostMapping("/recommend")
    public CareerResponse recommendCareer(@RequestBody SkillRequest request) {
        return careerService.recommendCareer(request.getSkills());
    }

    @GetMapping("/test")
    public String test() {
        return "API WORKING";
    }

}
