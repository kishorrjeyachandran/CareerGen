package com.careergen.backend.service;

import java.util.List;

import com.careergen.backend.model.CareerResponse;

public interface CareerService {
    CareerResponse recommendCareer(List<String> skills);
}
