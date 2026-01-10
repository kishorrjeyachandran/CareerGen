package com.careergen.backend.model;

import java.util.List;

public class CareerResponse {
    private String career;
    private List<String> requiredSkills;
    private String description;

    public CareerResponse(String career, List<String> requiredSkills, String description) {
        this.career = career;
        this.requiredSkills = requiredSkills;
        this.description = description;
    }

    public String getCareer() {
        return career;
    }

    public List<String> getRequiredSkills() {
        return requiredSkills;
    }

    public String getDescription() {
        return description;
    }
}
